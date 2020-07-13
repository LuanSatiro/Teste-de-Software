package application;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.lang.Double;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;


public class ApiTestParametrizado{
    @ParameterizedTest
    @CsvSource({"1,0.90", "2,0.90", "4,0.90", 
    "5,0.90", "6,0.95", "7,0.95", "9,0.95", "10,0.95", "11,1"
    , "12,1", "14,1", "15,1", "16, 1.021" ,"17,1.022","29,1.034","30,1.035","-1,0","31,0"})
    /// metodo 
    public void testeBase(int diaCalculado, float porc)throws IOException{
        /// valor nominal fixo
        float valorNominal = 1400.00f;
        float valorEsperado = valorNominal * porc;
        Aluguel dados = new Aluguel (diaCalculado, valorNominal);
        App example = new App();
        String response = example.run("https://aluguebug.herokuapp.com/calc?dados="+ dados.convert(diaCalculado, valorNominal));
        /// formatando para se adequar a string
        response = response.substring (1, response.length() - 2);
        response = response.replaceAll("\\\\","");
        /// passando para string
        String url_string = response.toString();
        JSONObject my_obj = new JSONObject(url_string);
        /// pegando elemento no json
        float url = my_obj.getFloat("valor_calculado");
        
        /// dias inválidos retorno -1
        if (diaCalculado > 30 || diaCalculado < 1) {
            assertEquals( -1 , url, 0.01);
        }else{
            assertEquals( valorEsperado , url, 0.01);
        }
    }
   
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv" , delimiter = ',')
    void testebasefile(int diaCalculado, float porc)throws IOException{
        /// valor nominal fixo
        float valorNominal = 1400.00f;
        float valorEsperado = valorNominal * porc;
        Aluguel dados = new Aluguel (diaCalculado, valorNominal);
        App example = new App();
        String response = example.run("https://aluguebug.herokuapp.com/calc?dados="+ dados.convert(diaCalculado, valorNominal));
        /// formatando para se adequar a string
        response = response.substring (1, response.length() - 2);
        response = response.replaceAll("\\\\","");
        /// passando para string
        String url_string = response.toString();
        JSONObject my_obj = new JSONObject(url_string);
        /// pegando elemento no json
        float url = my_obj.getFloat("valor_calculado");
        
        /// dias inválidos retorno -1
        if (diaCalculado > 30 || diaCalculado < 1) {
            assertEquals( -1 , url, 0.01);
        }else{
            assertEquals( valorEsperado , url, 0.01);
        }
    }

}
