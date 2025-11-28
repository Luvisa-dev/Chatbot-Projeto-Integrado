/*
 * Classe de serviço responsável por gerenciar todas as operações
 * relacionadas ao registro e controle de reclamações no sistema.
 */
package sistema;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementa os serviços principais do sistema de reclamações de TI.
 * Contém métodos relacionados aos requisitos funcionais RF001 ao RF009,
 * realizando operações como cadastro de máquinas, registro de reclamações,
 * cancelamento, confirmação, acompanhamento e definição de prioridade.
 * 
 * Essa classe simula um "banco de dados" interno usando HashMaps.
 * 
 * @author Luck
 * @version 1.0
 */
public class ReclamacaoService {

    /** Armazena todas as reclamações cadastradas no sistema */
    private Map<String, Reclamacao> banco = new HashMap<>();

    /** Armazena todas as máquinas cadastradas */
    private Map<String, String> maquinas = new HashMap<>();

    /**
     * RF001 – Cadastrar máquinas.
     * Cria o ID da máquina baseado no modelo e código, e armazena internamente.
     * 
     * @param modelo modelo da máquina (ex: "PC", "Notebook")
     * @param codigo código numérico da máquina (0–50)
     * @return retorna o ID formado como Modelo_Código
     */
    public String cadastrarMaquina(String modelo, int codigo) {
        String id = modelo + "_" + codigo;
        maquinas.put(id, modelo);
        return id;
    }

    /**
     * RF003 – Registrar reclamação.
     * Gera o ID da reclamação com base nos dados fornecidos.
     * 
     * @param idMaquina ID da máquina relacionada à reclamação
     * @param prioridade prioridade atribuída (1–3)
     * @param problema descrição do problema informado pelo servidor
     * @return objeto Reclamacao criado e armazenado
     */
    public Reclamacao registrarReclamacao(String idMaquina, int prioridade, String problema) {
        String idReclamacao = idMaquina + "_" + prioridade + "_" + problema;
        Reclamacao r = new Reclamacao(idReclamacao, idMaquina, prioridade, problema);
        banco.put(idReclamacao, r);
        return r;
    }

    /**
     * RF004 – Confirmar reclamação.
     * Define o campo "confirmacao" da reclamação.
     * 
     * @param idReclamacao ID da reclamação a confirmar
     * @return retorna o texto "confirmado"
     */
    public String confirmar(String idReclamacao) {
        Reclamacao r = banco.get(idReclamacao);
        r.confirmacao = "confirmado";
        return r.confirmacao;
    }

    /**
     * RF002 – Adiar atendimento.
     * Atualiza o status da reclamação para "Adiado".
     * 
     * @param idReclamacao ID da reclamação a ser adiada
     * @param motivo motivo do adiamento
     * @return o novo status formatado
     */
    public String adiar(String idReclamacao, String motivo) {
        Reclamacao r = banco.get(idReclamacao);
        r.status = "Adiado: " + motivo;
        return r.status;
    }

    /**
     * RF005 – Criar resposta automática.
     * Define a resposta padrão "Resposta".
     * 
     * @param idReclamacao ID da reclamação
     * @return retorna a string "Resposta"
     */
    public String respostaAutomatica(String idReclamacao) {
        Reclamacao r = banco.get(idReclamacao);
        r.resposta = "Resposta";
        return r.resposta;
    }

    /**
     * RF006 – Definir prioridade.
     * Atualiza o campo de prioridade da reclamação.
     * 
     * @param idReclamacao ID da reclamação
     * @param novaPrioridade prioridade nova (1–3)
     * @return retorna a prioridade atualizada
     */
    public int definirPrioridade(String idReclamacao, int novaPrioridade) {
        Reclamacao r = banco.get(idReclamacao);
        r.prioridade = novaPrioridade;
        return r.prioridade;
    }

    /**
     * RF007 – Cancelar reclamação.
     * Atualiza o status para Cancelado.
     * 
     * @param idReclamacao ID da reclamação
     * @param motivo motivo do cancelamento
     * @return novo status formatado
     */
    public String cancelar(String idReclamacao, String motivo) {
        Reclamacao r = banco.get(idReclamacao);
        r.status = "Cancelado: " + motivo;
        return r.status;
    }

    /**
     * RF008 – Acompanhar andamento.
     * Retorna o status atual da reclamação.
     * 
     * @param idReclamacao ID da reclamação
     * @return status atual da manutenção
     */
    public String acompanhar(String idReclamacao) {
        return banco.get(idReclamacao).status;
    }

    /**
     * RF009 – Visualizar reclamação.
     * Retorna o objeto Reclamacao completo.
     *
     * @param idReclamacao ID da reclamação
     * @return objeto Reclamacao correspondente
     */
    public Reclamacao visualizar(String idReclamacao) {
        return banco.get(idReclamacao);
    }
}
