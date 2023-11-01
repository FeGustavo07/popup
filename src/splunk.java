package org.example;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> diferencasDeTempo = new ArrayList<>();
        List<String> sendIds = new ArrayList<>();

        try {
            // Crie um leitor de JSON a partir do arquivo
            JsonReader jsonReaderLogSJ4 = Json.createReader(new FileReader("C:\\Users\\Gustavo\\OneDrive\\Documents\\estudos\\log2.json"));
            JsonReader jsonReaderLogEV4 = Json.createReader(new FileReader("C:\\Users\\Gustavo\\OneDrive\\Documents\\estudos\\log1.json"));

            // Leia o JSON em um array de objetos
            JsonArray jsonArrayLogSJ4 = jsonReaderLogSJ4.readArray();
            jsonReaderLogSJ4.close();

            JsonArray jsonArrayLogEV4 = jsonReaderLogEV4.readArray();
            jsonReaderLogEV4.close();

            // Loop pelos objetos no array
            for (JsonObject jsonObjectSJ4 : jsonArrayLogSJ4.getValuesAs(JsonObject.class)) {
                // Acesse o campo "email" de cada objeto

                JsonObject userObject = jsonObjectSJ4.getJsonObject("user");

                String id = userObject.getString("id");
                String timestampSJ4 = jsonObjectSJ4.getString("timestamp");

                for (JsonObject jsonObjectEV4 : jsonArrayLogEV4.getValuesAs(JsonObject.class)) {
                    String sendId = jsonObjectEV4.getString("SendId");
                    String timestampEV4 = jsonObjectEV4.getString("timestamp");

                    if (sendId.equals(id)) {
                        int timeEV4 = Integer.parseInt(timestampEV4.substring(20));
                        int timeSJ4 = Integer.parseInt(timestampSJ4.substring(20));

                        int diferenca = timeEV4 - timeSJ4;

                        diferencasDeTempo.add(diferenca);
                        sendIds.add(sendId);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < diferencasDeTempo.size(); i++) {
            if (diferencasDeTempo.get(i) > 100) {
                System.out.println("Diferença: " + diferencasDeTempo.get(i));
                System.out.println("SendId: " + sendIds.get(i));
            }
        }
    }
}



 <dependencies>
        <dependency>
            <groupId>javax.json</groupId>
            <artifactId>javax.json-api</artifactId>
            <version>1.1.4</version> <!-- Verifique a versão mais recente -->
        </dependency>
        <dependency>
            <groupId>org.glassfish</groupId>
            <artifactId>javax.json</artifactId>
            <version>1.1.4</version> <!-- Verifique a versão mais recente -->
        </dependency>
    </dependencies>
