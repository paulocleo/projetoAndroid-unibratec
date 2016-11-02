package br.com.juridiario.Banco;

/**
 * Created by PCAC on 25/10/2016.
 */
public interface ProcessoContract {

    String NOME_TABELA         = "tb_processos";
    String NOME_BANCO          = "dbProcesso";
    String ID_PROCESSO         = "_id";
    String DES_EDICAO_COMPLETA = "des_edicao_completa";
    String PROCESSO_TEXTO      = "des_processo_texto";
    String DES_ADVOGADO        = "des_advogado";
    String NUM_PROCESSO        = "num_processo";
    String DES_EDICAO          = "des_edicao";

    String[] ALL_COLUMNS = {
            ID_PROCESSO,
            DES_EDICAO_COMPLETA,
            PROCESSO_TEXTO,
            DES_ADVOGADO,
            NUM_PROCESSO,
            DES_EDICAO
    };
}
