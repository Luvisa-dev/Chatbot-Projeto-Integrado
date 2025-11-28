/*
 * Classe que representa uma reclamação registrada no sistema.
 * Essa classe armazena todos os dados referentes à reclamação
 * feita pelo Servidor Público.
 */
package sistema;

/**
 * Implementa o modelo de dados de uma reclamação do sistema de TI.
 * Cada reclamação contém informações como ID, máquina associada,
 * prioridade, status, confirmação e resposta automática.
 * 
 * @author Luck
 * @version 1.0
 */
public class Reclamacao {

    /** Identificador completo da reclamação (Modelo_Código_Prioridade_Descrição) */
    public String idReclamacao;

    /** ID da máquina relacionada à reclamação (Modelo_Código) */
    public String idMaquina;

    /** Prioridade atribuída à reclamação (1 a 3) */
    public int prioridade;

    /** Problema descrito pelo Servidor Público */
    public String problema;

    /** Status atual da manutenção (Pendente, Adiado, Cancelado, etc.) */
    public String status;

    /** Confirmação enviada pelo sistema ao servidor */
    public String confirmacao;

    /** Resposta automática enviada pelo sistema */
    public String resposta;

    /**
     * Construtor da classe Reclamacao.
     * Inicializa uma nova reclamação com dados fornecidos.
     * 
     * @param idReclamacao ID completo da reclamação
     * @param idMaquina ID da máquina selecionada
     * @param prioridade nível de prioridade (1–3)
     * @param problema descrição do problema da máquina
     */
    public Reclamacao(String idReclamacao, String idMaquina, int prioridade, String problema) {
        this.idReclamacao = idReclamacao;
        this.idMaquina = idMaquina;
        this.prioridade = prioridade;
        this.problema = problema;
        this.status = "Pendente"; // Valor inicial padrão
    }
}
