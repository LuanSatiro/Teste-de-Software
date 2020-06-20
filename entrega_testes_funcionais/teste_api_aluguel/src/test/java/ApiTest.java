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


public class ApiTest{
    /// generalizando metodo
    public void testeBase(int diaCalculado, double porc)throws IOException{
        /// valor nominal fixo
        double valorNominal = 1400.00;
        
        /// dias validos 1 ao 30, fora isso, retornara - 1
        double result = valorNominal - (valorNominal * porc);
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
        int url = my_obj.getInt("valor_calculado");
        /// dias inválidos retorno -1
        assertEquals( result , url);  
    }
    @Test
    public void testNominaloneLMSO()throws IOException{
        ///dia -1
        int diaCalculado = -1;
        /// valor nominal fixo
        double valorNominal = 1400.00;
        /// dias validos 1 ao 30, fora isso, retornara - 1
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
        int url = my_obj.getInt("valor_calculado");
        /// dias inválidos retorno -1
        assertEquals( -1 , url);  
    }
    @Test
    public void testNominaltwoLMSO()throws IOException{
        ///dia 1
        testeBase(1,0.10);
    }
    @Test
    public void testNominaltreeLMSO()throws IOException{
        ///dia 2
        testeBase(2,0.10);
    }
    @Test
    public void testNominalforLMSO()throws IOException{
        ///dia 4
        testeBase(4,0.10);
    }
    @Test
    public void testNominalfiveLMSO()throws IOException{
        ///dia 5
        testeBase(5,0.10);
    }
    @Test
    public void testNominalsixLMSO()throws IOException{
        ///dia 6
        testeBase(6,0.05);
    }
    @Test
    public void testNominalsevenLMSO()throws IOException{
        ///dia 7
        testeBase(7,0.05);
    }
    @Test
    public void testNominaleightLMSO()throws IOException{
        ///dia 9
        /// bug encontrado
        testeBase(9,0.05);
    }
    @Test
    public void testNominalnineLMSO()throws IOException{
        ///dia 10
        testeBase(10,0.05);
    }
    @Test
    public void testNominaltenLMSO()throws IOException{
        ///dia 11
        testeBase(11,0);
    }
    @Test
    public void testNominalelevenLMSO()throws IOException{
        ///dia 12
        testeBase(12,0);
    }
    @Test
    public void testNominaltwelveLMSO()throws IOException{
        ///dia 14
        testeBase(14,0);
    }
    @Test
    public void testNominalthirteenLMSO()throws IOException{
        ///dia 15
        ///bug encontrado
        testeBase(15,0);
    }
    @Test
    public void testNominalfourteenLMSO()throws IOException{
        ///dia 16
        int diaCalculado = 16;
        /// valor nominal fixo
        double valorNominal = 1400.00;
        /// dias validos 1 ao 30, fora isso, retornara - 1
        ///dia 16 ao 30 mult de 2% e acrescismo de 0,01% ao dia
        double result = valorNominal + (valorNominal * 0.021);
        
      
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
        int url = my_obj.getInt("valor_calculado");
        /// dias inválidos retorno -1
        assertEquals( result , url);  
    }
    @Test
    public void testNominalfifteenLMSO()throws IOException{
        ///dia 17
        int diaCalculado = 17;
        /// valor nominal fixo
        double valorNominal = 1400.00;
        /// dias validos 1 ao 30, fora isso, retornara - 1
        ///dia 16 ao 30 mult de 2% e acrescismo de 0,01% ao dia
        double result = valorNominal + (valorNominal * 0.022);
        
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
        int url = my_obj.getInt("valor_calculado");
        /// dias inválidos retorno -1
        assertEquals( result , url);  
    }
    @Test
    public void testNominalsixteenLMSO()throws IOException{
        ///dia 29
        int diaCalculado = 29;
        /// valor nominal fixo
        double valorNominal = 1400.00;
        /// dias validos 1 ao 30, fora isso, retornara - 1
        ///dia 16 ao 30 mult de 2% e acrescismo de 0,01% ao dia
        double result = valorNominal + (valorNominal * 0.034) ;
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
        int url = my_obj.getInt("valor_calculado");
        /// dias inválidos retorno -1
        assertEquals( result , url);    
    }
    @Test
    public void testNominalseventeenLMSO()throws IOException{
        ///dia 30
        int diaCalculado = 30;
        /// valor nominal fixo
        double valorNominal = 1400.00;
        /// dias validos 1 ao 30, fora isso, retornara - 1
        ///dia 16 ao 30 mult de 2% e acrescismo de 0,01% ao dia
        double result = valorNominal + (valorNominal * 0.035) ;
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
        int url = my_obj.getInt("valor_calculado");
        /// dias inválidos retorno -1
        assertEquals( result , url); 
    }
    @Test
    public void testNominaleighteenLMSO()throws IOException{
        ///dia 31
        int diaCalculado = 31;
        /// valor nominal fixo
        double valorNominal = 1400.00;
        /// dias validos 1 ao 30, fora isso, retornara - 1
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
        int url = my_obj.getInt("valor_calculado");
        /// dias inválidos retorno -1
        assertEquals( -1 , url);  
    }
   
}