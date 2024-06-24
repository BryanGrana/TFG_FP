package tfg.bryan;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class Header extends JPanel {

	private static final long serialVersionUID = 1L;

	public Header() {
		initComponents();
	}

	
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		imageAvatar1 = new ImageAvatar();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();

		imageAvatar1.setBorderSize(3);
		imageAvatar1.setBorderSpace(2);
		imageAvatar1.setGradientColor1(new java.awt.Color(255, 0, 0));
		imageAvatar1.setGradientColor2(new java.awt.Color(27, 0, 255));
		imageAvatar1.setImage(new ImageIcon(Header.class.getResource("/images/logo.png"))); // NOI18N
		jLabel1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
		jLabel1.setForeground(new Color(0, 0, 0));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("WorkFlow Hub");
		jLabel2.setFont(new Font("SansSerif", Font.PLAIN, 12)); // NOI18N
		jLabel2.setForeground(new Color(58, 58, 58));
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("By: Bryan Graña Martínez");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(imageAvatar1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(jLabel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(20)
					.addComponent(imageAvatar1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabel1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabel2)
					.addContainerGap())
		);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private ImageAvatar imageAvatar1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	// End of variables declaration//GEN-END:variables
}
