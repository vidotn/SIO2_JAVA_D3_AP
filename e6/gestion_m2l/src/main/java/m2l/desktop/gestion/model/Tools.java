package m2l.desktop.gestion.model;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Tools
{
    public static String convertInputStreamToString(java.io.InputStream is)
    {
        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(is));

        String output;
        StringBuilder response = new StringBuilder();
        while (true) {
            try {
                if (!((output = br.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            response.append(output);

        }

        return response.toString();
    }


    public static List InterventionsJSonToList(String jsonResponse)
    {

        List<Intervention> liste = new ArrayList<>();

        try (JsonReader reader = new JsonReader(new StringReader(jsonResponse))) {
            //reader.setLenient(true);
            reader.beginArray(); // Commence à lire le tableau JSON
            while (reader.hasNext()) {
                Intervention objet = new Gson().fromJson(reader, Intervention.class);
                liste.add(objet);
            }
            reader.endArray(); // Fin du tableau JSON
        } catch (Exception e) {
            e.printStackTrace();
        }

        return liste;
    }

    public static List<Salle> SallesJSonToList(String jsonResponse) {

        List<Salle> liste = new ArrayList<>();

        try (JsonReader reader = new JsonReader(new StringReader(jsonResponse))) {
            //reader.setLenient(true);
            reader.beginArray(); // Commence à lire le tableau JSON
            while (reader.hasNext()) {
                Salle objet = new Gson().fromJson(reader, Salle.class);
                liste.add(objet);
            }
            reader.endArray(); // Fin du tableau JSON
        } catch (Exception e) {
            e.printStackTrace();
        }

        return liste;
    }



    public static List<Climatiseur> ClimatiseursJSonToList(String jsonResponse) {

        List<Climatiseur> liste = new ArrayList<>();

        try (JsonReader reader = new JsonReader(new StringReader(jsonResponse))) {
            //reader.setLenient(true);
            reader.beginArray(); // Commence à lire le tableau JSON
            while (reader.hasNext()) {
                Climatiseur objet = new Gson().fromJson(reader, Climatiseur.class);
                liste.add(objet);
            }
            reader.endArray(); // Fin du tableau JSON
        } catch (Exception e) {
            e.printStackTrace();
        }

        return liste;
    }

   /* public static void updateClimatiseur(Climatiseur c) throws IOException
    {
        try {
            String apiUrl = getApiUrl() + "climatiseurs/" + c.getId();

            URL url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PATCH");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);
            String jsonInputString = new Gson().toJson(c);
            try (java.io.OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

              int responseCode = conn.getResponseCode();

              System.out.println("Response Code : " + responseCode);
        }catch (Exception e) {
            e.printStackTrace();
        }


    }*/

}
