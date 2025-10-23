package m2l.desktop.gestion.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import m2l.desktop.gestion.LocalDateTimeAdapter;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ModelQueries {

    // URL de l'API à modifier pour correspondre à votre API
    private static String API_URL = "http://localhost:8080/SIO2/laravel/e6/correction_site_m2l_12.4/public/api/";


    /************************************  INTERVENTIONS  ****************************************/
    public static List<Intervention> getInterventionsFromApi() throws IOException {
        //connexion à l'API et récupération des données
        String apiUrl = API_URL + "interventions";

        URL url = new URL(apiUrl);
        List<Intervention> liste_des_interventions = null;

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");


        if (conn.getResponseCode() == 200) {

            System.out.println("ModelQueries :  Response from API: " + conn.getResponseMessage() + "Chaine :" + conn.getInputStream().toString());

            String jsonResponse = Tools.convertInputStreamToString(conn.getInputStream());

            System.out.println("ModelQueries : JSON Response : " + jsonResponse);

            liste_des_interventions = Tools.InterventionsJSonToList(jsonResponse);
        } else {
            System.out.println("ModelQueries : Failed : HTTP error code : "
                    + conn.getResponseCode());
        }
        conn.disconnect();
        return liste_des_interventions;
    }

    public static void updateInterventionViaApi(Intervention interventionSelectionnee) {

        try {

            String apiUrl = API_URL + "interventions/" +interventionSelectionnee.getId_intervention();


            System.out.println("Modification de l'intervention n°" + interventionSelectionnee + " via l'API..."+apiUrl);

            URL url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");

            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();

            String jsonInputString = gson.toJson(interventionSelectionnee);
            try (java.io.OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

          /*  String param1 = URLEncoder.encode(interventionSelectionnee.getMotif(), StandardCharsets.UTF_8.toString());
            String formData = "motif=" + param1;

            // Écrire les données dans le corps de la requête
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = formData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
*/
            int responseCode = conn.getResponseCode();

            System.out.println("Response Code : " + responseCode);

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /************************************  SALLES  ****************************************/
    public static List<Salle> getSallesFromApi() {
        //connexion à l'API et récupération des données
        String apiUrl = API_URL + "salles";

        URL API = null;
        List<Salle> listeSalles = null;

        try {
            API = new URL(apiUrl);

            HttpURLConnection conn = null;

            conn = (HttpURLConnection) API.openConnection();

            conn.setRequestMethod("GET");

            conn.setRequestProperty("Accept", "application/json");


            if (conn.getResponseCode() == 200) {

                System.out.println("ModelQueries :  Response from API: " + conn.getResponseMessage() + "Chaine :" + conn.getInputStream().toString());

                String jsonResponse = Tools.convertInputStreamToString(conn.getInputStream());

                System.out.println("ModelQueries : JSON Response : " + jsonResponse);

                listeSalles = Tools.SallesJSonToList(jsonResponse);
            } else {
                System.out.println("ModelQueries : Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listeSalles;
    }

    public static Salle getSalleById(int id) {
        String apiUrl = API_URL + "salles/" + id;

        URL url = null;
        Salle salle = null;
        try {
            url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() == 200) {
                String jsonResponse = Tools.convertInputStreamToString(conn.getInputStream());
                salle = new Gson().fromJson(jsonResponse, Salle.class);

            }

            conn.disconnect();
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return salle;
    }

    //************************************  CLIMATISEURS  ****************************************/
    public static List<Climatiseur> getClimatiseursFromApi() throws IOException {
        String apiUrl = API_URL + "climatiseurs";

        URL url = new URL(apiUrl);
        List<Climatiseur> liste_des_climatiseurs = new ArrayList<>();

        System.out.println("ModelQueries : Connexion à l'API Climatiseurs à l'URL : " + apiUrl);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");


        if (conn.getResponseCode() == 200) {

            System.out.println("ModelQueries :  Response from API: " + conn.getResponseMessage() + "Chaine :" + conn.getInputStream().toString());

            String jsonResponse = Tools.convertInputStreamToString(conn.getInputStream());

            liste_des_climatiseurs = Tools.ClimatiseursJSonToList(jsonResponse);
        } else {
            System.out.println("ModelQueries : Failed : HTTP error code : "
                    + conn.getResponseCode());
        }
        conn.disconnect();
        return liste_des_climatiseurs;
    }


    public static void insertClimatiseurViaApi(Climatiseur c) {
        try {
            String apiUrl = API_URL + "climatiseurs";

            System.out.println("Insertion du climatiseur via l'API à l'URL : " + apiUrl);

            URL url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);
            String jsonInputString = new Gson().toJson(c);

            System.out.println("Insertion du climatiseur via l'API : " + jsonInputString);


            try (java.io.OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            int responseCode = conn.getResponseCode();

            System.out.println("Response Code : " + responseCode+ " - Response Message : " + conn.getResponseMessage());

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateClimatiseur(Climatiseur c) throws IOException {
        try {
            String apiUrl = API_URL + "climatiseurs/" + c.getId();

            URL url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
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

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void deleteClimatiseur(Climatiseur selectedItem) {
        try {
            String apiUrl = API_URL + "climatiseurs/" + selectedItem.getId();

            URL url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            int responseCode = conn.getResponseCode();

            System.out.println("Response Code : " + responseCode);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static Marque getMarqueById(int id) throws IOException {

        String apiUrl = API_URL + "marques/" + id;

        System.out.println("ModelQueries - getMarqueById : API URL : " + apiUrl);

        URL url = null;
        Marque marque = null;

        try {
            url = new URL(apiUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() == 200) {
                String jsonResponse = Tools.convertInputStreamToString(conn.getInputStream());
                System.out.println("ModelQueries - getMArqueById : JSON Response : " + jsonResponse);
                marque = new Gson().fromJson(jsonResponse, Marque.class);

            }

            conn.disconnect();
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("ModelQueries - getMarqueById : Marque récupérée : " + marque);

        return marque;
    }
}
