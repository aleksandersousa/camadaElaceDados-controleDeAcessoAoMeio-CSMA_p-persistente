/* ***************************************************************
Autor: Aleksander Santos Sousa*
Matricula: 201810825*
Inicio: 07/12/2020*
Ultima alteracao: 10/12/2020*
Nome: Simulador de Redes*
Funcao: Simular o envio de uma mensagem de texto.
*************************************************************** */

package view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Erro {
  /*
   * ************************************************************** 
   * Metodo: tratarErroMensagemVazia
   * Funcao: informa o usuario se a caixa de texto estiver vazia.
   * Parametros: nulo*
   * Retorno: void*
   */
  public static void tratarErroMensagemVazia() {
    JOptionPane.showMessageDialog(null, "Caixa de texto vazia!", "Alerta!", JOptionPane.ERROR_MESSAGE);
  }

  /*
   * ************************************************************** 
   * Metodo: tratarErroMensagemEmAdamento
   * Funcao: Nao deixa o usuario enviar uma nova mensagem ate a ultima ter sido completada.
   * Parametros: nulo*
   * Retorno: void*
   */
  public static void tratarErroMensagemEmAdamento() {
    JOptionPane.showMessageDialog(null, "Mensagem em andamento!", "Alerta!", JOptionPane.ERROR_MESSAGE);
  }

  /*
   * ************************************************************** 
   * Metodo: tratarErroCRC
   * Funcao: informa o usuario que houve na transmissao do dado.
   * Parametros: nulo*
   * Retorno: void*
   */
  public static void tratarErroCRC() {
    JOptionPane pane = new JOptionPane(
      "Colisao! Aguardando o proximo slot de tempo para reenviar o quadro...", 
      JOptionPane.WARNING_MESSAGE,
      JOptionPane.DEFAULT_OPTION,
      null,
      new Object[]{}
    );

    final JDialog dialog = pane.createDialog("Erro");

    new Thread(new Runnable(){
      @Override
      public void run() {
        try {
          Thread.sleep(3000);
          dialog.dispose();
        } catch (Exception e) {
          e.printStackTrace();
        }
      } 
    }).start();
    dialog.setVisible(true);
  }
}
