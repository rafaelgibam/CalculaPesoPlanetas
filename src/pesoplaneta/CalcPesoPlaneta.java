package pesoplaneta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.GridLayout;

public class CalcPesoPlaneta extends JFrame {

	JLabel lbpt;
	JTextField tfpt;
	JButton btcp;
	JLabel lbsp;
	JRadioButton jrbMercurio;
	JRadioButton jrbMarte;
	JRadioButton jrbSaturno;
	JRadioButton jrbVenus;
	JRadioButton jrbJupiter;
	JRadioButton jrbUrano;
	ButtonGroup btgGrupoPlaneta;
	
	CalcPesoPlaneta(){
		
		Container ctp = getContentPane();
		ctp.setLayout(new GridLayout(2,1));
		
		Container ctpeso = new JPanel();
		ctpeso.setLayout(new GridLayout(2,2));

		lbpt = new JLabel("Peso na Terra (kg): ");
		tfpt = new JTextField();
		btcp = new JButton("Calcular Peso");
		ctpeso.add(lbpt);
		ctpeso.add(new JPanel());
		ctpeso.add(tfpt);
		ctpeso.add(btcp);
		
		Container ctPlaneta = new JPanel();
		ctPlaneta.setLayout(new GridLayout(3,3));
		
		lbsp = new JLabel("Selecione o Planeta: ");
		jrbMercurio = new JRadioButton("Mercúrio", false);
		jrbMarte = new JRadioButton("Marte", false);
		jrbSaturno = new JRadioButton("Saturno", false);
		jrbVenus = new JRadioButton("Vênus", false);
		jrbJupiter = new JRadioButton("Júpiter", false);
		jrbUrano = new JRadioButton("Urano", false);
		ctPlaneta.add(lbsp);
		ctPlaneta.add(new JPanel());
		ctPlaneta.add(new JPanel());
		ctPlaneta.add(jrbMercurio);
		ctPlaneta.add(jrbMarte);
		ctPlaneta.add(jrbSaturno);
		ctPlaneta.add(jrbVenus);
		ctPlaneta.add(jrbJupiter);
		ctPlaneta.add(jrbUrano);

		btgGrupoPlaneta = new ButtonGroup();
		btgGrupoPlaneta.add(jrbMercurio);
		btgGrupoPlaneta.add(jrbMarte);
		btgGrupoPlaneta.add(jrbSaturno);
		btgGrupoPlaneta.add(jrbVenus);
		btgGrupoPlaneta.add(jrbJupiter);
		btgGrupoPlaneta.add(jrbUrano);
		
		ctp.add(ctpeso);
		ctp.add(ctPlaneta);
		
		btcp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//se o peso for vazio e os RaioButton também!
				if (tfpt.getText().equals("") && !jrbMarte.isSelected() && !jrbMercurio.isSelected()
						&& !jrbSaturno.isSelected() && !jrbVenus.isSelected() && !jrbJupiter.isSelected()
						&& !jrbUrano.isSelected()) {
					JOptionPane.showMessageDialog(null, "Digite seu Peso e selecione um planeta para calcular seu peso!","Erro digitação", JOptionPane.OK_OPTION);
				}
				//se o peso for <> de vazio emos radios tiverem nulos
				else if(!tfpt.getText().equals("") && !jrbMarte.isSelected() && !jrbMercurio.isSelected()
						&& !jrbSaturno.isSelected() && !jrbVenus.isSelected() && !jrbJupiter.isSelected()
						&& !jrbUrano.isSelected()) {
					JOptionPane.showMessageDialog(null, "Selecione um planeta para calcular seu peso!","Erro digitação", JOptionPane.OK_OPTION);
				}
				//se o peso for <> de vazio e um dos radios tiver true
				else if (!tfpt.getText().equals("") && jrbMarte.isSelected() || jrbMercurio.isSelected()
						|| jrbSaturno.isSelected() || jrbVenus.isSelected() || jrbJupiter.isSelected()
						|| jrbUrano.isSelected()) {
					
						double peso = Integer.parseInt(tfpt.getText());
						
						//verifica qual planeta e calcula o peso
						if(jrbMercurio.isSelected()) {
							peso = (peso/10)*0.37;
							JOptionPane.showMessageDialog(null, "Seu peso em Mercurio é: "+peso,"Peso Mercurio", JOptionPane.OK_OPTION);
						}else if(jrbMarte.isSelected()) {
							peso = (peso/10)*0.38;
							JOptionPane.showMessageDialog(null, "Seu peso em Martete é: "+peso,"Peso Marte", JOptionPane.OK_OPTION);
						}else if(jrbSaturno.isSelected()) {
							peso = (peso/10)*1.15;
							JOptionPane.showMessageDialog(null, "Seu peso em Saturno é: "+peso,"Peso Saturno", JOptionPane.OK_OPTION);
						}else if(jrbVenus.isSelected()) {
							peso = (peso/10)*0.88;
							JOptionPane.showMessageDialog(null, "Seu peso em Vênus é: "+peso,"Peso Vênus", JOptionPane.OK_OPTION);
						}else if(jrbJupiter.isSelected()) {
							peso = (peso/10)*2.64;
							JOptionPane.showMessageDialog(null, "Seu peso em Júpiter é: "+peso,"Peso Júpiter", JOptionPane.OK_OPTION);
						}else if(jrbUrano.isSelected()) {
							peso = (peso/10)*1.17;
							JOptionPane.showMessageDialog(null, "Seu peso em Urano é: "+peso,"Peso Urano", JOptionPane.OK_OPTION);
						}else {
							JOptionPane.showMessageDialog(null, "Selecione um planeta para calcular seu peso!","Erro seleção", JOptionPane.OK_OPTION);
						}
				}else {
					JOptionPane.showMessageDialog(null, "Digite o Peso para calcular seu peso!","Erro", JOptionPane.OK_OPTION);
				}
			}
		});
		
		setTitle("Calcular Peso nos Planetas");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
