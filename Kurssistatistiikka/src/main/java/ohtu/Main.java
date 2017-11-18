package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "011120775";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String submissionUrl = "https://studies.cs.helsinki.fi/ohtustats/students/"+studentNr+"/submissions";
        String courseUrl = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        String statsUrl = "https://studies.cs.helsinki.fi/ohtustats/stats";

        String submissionBodyText = Request.Get(submissionUrl).execute().returnContent().asString();
        String courseBodyText = Request.Get(courseUrl).execute().returnContent().asString();
        String statsBodyText = Request.Get(statsUrl).execute().returnContent().asString();

        Gson submissionMapper = new Gson();
        Submission[] subs = submissionMapper.fromJson(submissionBodyText, Submission[].class);
        Gson courseMapper = new Gson();
        Course course = courseMapper.fromJson(courseBodyText, Course.class);

        JsonParser parser = new JsonParser();
        JsonObject stats = parser.parse(statsBodyText).getAsJsonObject();

        System.out.println("Kurssi: Ohjelmistotuotanto, syksy 2017");
        System.out.println("");
        System.out.println("opiskelijanumero: " + studentNr);
        System.out.println("");
        int excercises = 0;
        int hours = 0;
        int i = 0;
        for (Submission submission : subs) {
            submission.setMaksimi(course.getExercises().get(i));
            System.out.println(submission);
            excercises += submission.getExercises().size();
            hours += submission.getHours();
            i++;
        }

        int palautuksia = 0;
        int tehtavia = 0;

        // System.out.println("mitäs " + stats.get("1"));

        System.out.println("yhteensä: " + excercises + " tehtävää " + hours + " tuntia");

        i = 0;
        while (i < stats.size()) {
            // System.out.println("wot: " + stats.get("" + (i + 1)).getAsJsonObject().get("exercise_total"));
            palautuksia += stats.get("" + (i + 1)).getAsJsonObject().get("students").getAsInt();
            tehtavia += stats.get("" + (i + 1)).getAsJsonObject().get("exercise_total").getAsInt();
            i++;
        }

        System.out.println("kurssilla yhteensä " + palautuksia + " palautusta, palautettuja tehtäviä " + tehtavia + " kpl");
    }
}