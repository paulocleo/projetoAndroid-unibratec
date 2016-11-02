package br.com.juridiario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PCAC on 19/10/2016.
 */
public class JsonUtil {

    public static List<ItemProcesso> fromJson(String json) throws JSONException {

        List<ItemProcesso> lista = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);

        for(int i=0; i < jsonArray.length(); i++){
            JSONObject object = (JSONObject) jsonArray.get(i);
            String desEdicaoCompleta = (String)  object.get("desEdicaoCompleta");
            String processoTexto     = (String)  object.get("processoTexto");
            String desAdvogado       = (String)  object.get("desAdvogado");
            String desProcesso       = (String)  object.get("desProcesso");
            String desEdicao         = (String)  object.get("desEdicao");
            Integer codId            = (Integer) object.get("codId");

            lista.add(new ItemProcesso(desEdicaoCompleta, processoTexto, desAdvogado, desProcesso, desEdicao, codId));
        }

        return lista;
    }
}