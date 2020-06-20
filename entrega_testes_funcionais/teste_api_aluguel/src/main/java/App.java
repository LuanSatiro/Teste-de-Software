package application;

import java.util.Scanner; 
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class App{
    OkHttpClient client = new OkHttpClient();

    String run(String url) throws IOException {
    Request request = new Request.Builder()
        .url(url)
        .build();

    try (Response response = client.newCall(request).execute()) {
      return response.body().string();
    }
    }
    public static void main(String  []  args) throws IOException{

        Scanner myObj = new Scanner(System.in);  
        System.out.println("Entre com o valor nominal:");

        double valorNominal = myObj.nextFloat();  

        System.out.println("O valor nominal " + valorNominal); 
        

        System.out.println("Entre com o dia de calculo:");

        int diaCalculado = myObj.nextInt();  

        System.out.println("Dia de calculo" + diaCalculado);

        Aluguel dados = new Aluguel (diaCalculado, valorNominal); 
    
        App example = new App();
        String response = example.run("https://aluguebug.herokuapp.com/calc?dados="+ dados.convert(diaCalculado, valorNominal));
        System.out.println("API Web sendo consumida");
        System.out.println("Luan matheus Satiro de Oliveira");
        System.out.println(response);
        
        
        
        
        
        
        

        



        /*
        String json_str = "{\"userId\":1,\"id\":1,\"title\":\"Json in Java\",\"completed\":true}";
    
        JSONObject my_obj = new JSONObject(json_str);
        int userId = my_obj.getInt("userId");
        String title = my_obj.getString("title");
        boolean completed = my_obj.getBoolean("completed");

        System.out.println(userId);
        System.out.println(title);
        System.out.println(completed);
        */
    }
}
