package sistema;

/**
 * Classe principal do sistema de Reclamações de TI.
 * <p>
 * É responsável por demonstrar o fluxo básico do programa,
 * executando os requisitos funcionais implementados no serviço
 * {@code ReclamacaoService}.
 * </p>
 *
 * <p>Este exemplo simula o cadastro de máquinas, registro de reclamações,
 * alteração de prioridade, acompanhamento, cancelamento, entre outros.</p>
 *
 * @author Luck
 * @version 1.0
 */
public class Main {

    /**
     * Método principal que executa a demonstração dos requisitos do sistema.
     * <p>
     * Cada bloco representa um requisito funcional (RF) que é chamado
     * através dos métodos da classe {@code ReclamacaoService}.
     * </p>
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {

        System.out.println("=== Sistema de Reclamações de TI ===\n");

        // Instancia o serviço responsável pelas operações principais do sistema
        ReclamacaoService service = new ReclamacaoService();

        /**
         * RF001 – Cadastro de Máquina
         * Cria um identificador único para uma máquina e retorna seu ID.
         */
        String idMaquina = service.cadastrarMaquina("PC", 10);
        System.out.println("Máquina cadastrada: " + idMaquina);

        /**
         * RF003 – Registro de Reclamação
         * Gera uma nova reclamação associada à máquina cadastrada.
         */
        Reclamacao r = service.registrarReclamacao(idMaquina, 2, "Impressora não imprime");
        System.out.println("Reclamação registrada: " + r.idReclamacao);

        /**
         * RF004 – Confirmação da Reclamação
         * Envia uma resposta ao usuário confirmando o registro.
         */
        String confirmacao = service.confirmar(r.idReclamacao);
        System.out.println("Confirmação enviada: " + confirmacao);

        /**
         * RF005 – Resposta Automática
         * Gera uma sugestão automática com base no problema informado.
         */
        String resposta = service.respostaAutomatica(r.idReclamacao);
        System.out.println("Resposta automática: " + resposta);

        /**
         * RF006 – Alterar Prioridade
         * Atualiza a prioridade da reclamação existente.
         */
        int novaPrioridade = service.definirPrioridade(r.idReclamacao, 1);
        System.out.println("Nova prioridade: " + novaPrioridade);

        /**
         * RF002 – Adiar Atendimento
         * Atualiza o status da reclamação informando o adiamento.
         */
        String statusAdiado = service.adiar(r.idReclamacao, "Tecnico indisponivel");
        System.out.println("Status: " + statusAdiado);

        /**
         * RF008 – Acompanhar Reclamação
         * Consulta o status atual da reclamação em andamento.
         */
        String status = service.acompanhar(r.idReclamacao);
        System.out.println("Acompanhamento: " + status);

        /**
         * RF009 – Visualizar Reclamação Completa
         * Exibe todos os dados da reclamação selecionada.
         */
        Reclamacao visualizada = service.visualizar(r.idReclamacao);
        System.out.println("\nReclamação visualizada:");
        System.out.println("- ID: " + visualizada.idReclamacao);
        System.out.println("- Máquina: " + visualizada.idMaquina);
        System.out.println("- Prioridade: " + visualizada.prioridade);
        System.out.println("- Problema: " + visualizada.problema);
        System.out.println("- Status: " + visualizada.status);

        /**
         * RF007 – Cancelar Reclamação
         * Interrompe o atendimento e registra o motivo do cancelamento.
         */
        String cancelada = service.cancelar(r.idReclamacao, "Usuário desistiu");
        System.out.println("\nReclamação cancelada: " + cancelada);

        System.out.println("\n=== Programa finalizado ===");
    }
}
