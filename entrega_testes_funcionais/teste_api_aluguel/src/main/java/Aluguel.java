package application;

import java.util.Scanner; 
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Aluguel{
    private int dia;
    private float nominal;

    public Aluguel(int dia, float nominal){
        this.dia = dia;
        this.nominal = nominal;
    }
    public String convert(int diaCalculado, float valorNominal){
        Aluguel aluguel = new Aluguel( diaCalculado , valorNominal);
        JSONObject my_Obj = new JSONObject();
        my_Obj.put("valor_nominal", valorNominal);
        my_Obj.put("dia", diaCalculado);
        String json_string = my_Obj.toString();
        return json_string;
    }
}
