package sistema;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReclamacaoServiceTest {

    ReclamacaoService service = new ReclamacaoService();

    // 1 - Teste RF001: Cadastro de máquina
    @Test
    public void testCadastrarMaquina() {
        String id = service.cadastrarMaquina("ModeloX", 10);
        assertEquals("ModeloX_10", id);
    }

    // 2 - Teste RF003: Registrar reclamação
    @Test
    public void testRegistrarReclamacao() {
        service.cadastrarMaquina("PC", 1);
        Reclamacao r = service.registrarReclamacao("PC_1", 2, "Quebrou");
        assertEquals("PC_1_2_Quebrou", r.idReclamacao);
    }

    // 3 - Teste RF004: Confirmar reclamação
    @Test
    public void testConfirmarReclamacao() {
        service.cadastrarMaquina("PC", 1);
        Reclamacao r = service.registrarReclamacao("PC_1", 1, "Erro");
        String c = service.confirmar(r.idReclamacao);
        assertEquals("confirmado", c);
    }

    // 4 - Teste RF002: Adiar atendimento
    @Test
    public void testAdiarAtendimento() {
        service.cadastrarMaquina("PC", 1);
        Reclamacao r = service.registrarReclamacao("PC_1", 1, "Erro");
        String status = service.adiar(r.idReclamacao, "Sem técnico");
        assertEquals("Adiado: Sem técnico", status);
    }

    // 5 - Teste RF005: Resposta automática
    @Test
    public void testRespostaAutomatica() {
        service.cadastrarMaquina("PC", 1);
        Reclamacao r = service.registrarReclamacao("PC_1", 1, "Erro");
        String resposta = service.respostaAutomatica(r.idReclamacao);
        assertEquals("Resposta", resposta);
    }

    // 6 - Teste RF006: Definir nova prioridade
    @Test
    public void testDefinirPrioridade() {
        service.cadastrarMaquina("PC", 1);
        Reclamacao r = service.registrarReclamacao("PC_1", 1, "Erro");
        int pr = service.definirPrioridade(r.idReclamacao, 3);
        assertEquals(3, pr);
    }

    // 7 - Teste RF007: Cancelamento
    @Test
    public void testCancelarReclamacao() {
        service.cadastrarMaquina("PC", 1);
        Reclamacao r = service.registrarReclamacao("PC_1", 2, "Erro");
        String status = service.cancelar(r.idReclamacao, "Usuário desistiu");
        assertEquals("Cancelado: Usuário desistiu", status);
    }

    // 8 - Teste RF008: Acompanhar andamento
    @Test
    public void testAcompanharReclamacao() {
        service.cadastrarMaquina("PC", 1);
        Reclamacao r = service.registrarReclamacao("PC_1", 1, "Erro");
        assertEquals("Pendente", service.acompanhar(r.idReclamacao));
    }

    // 9 - Teste RF009: Visualizar reclamação
    @Test
    public void testVisualizarReclamacao() {
        service.cadastrarMaquina("PC", 1);
        Reclamacao r = service.registrarReclamacao("PC_1", 1, "Erro");
        Reclamacao visto = service.visualizar(r.idReclamacao);
        assertNotNull(visto);
    }

    // 10 - Teste Completo: Fluxo inteiro
    @Test
    public void testFluxoCompleto() {
        String idM = service.cadastrarMaquina("PC", 3);
        Reclamacao r = service.registrarReclamacao(idM, 2, "Travando");

        service.confirmar(r.idReclamacao);
        service.definirPrioridade(r.idReclamacao, 1);
        service.respostaAutomatica(r.idReclamacao);

        assertEquals("confirmado", r.confirmacao);
        assertEquals(1, r.prioridade);
        assertEquals("Resposta", r.resposta);
    }
}
