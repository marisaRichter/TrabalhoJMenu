/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uricer.menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author aluno
 */
public class Menu {
    JFrame frame;
    JPanel test;
    JToolBar toolbar;
    
    
    public Menu(){
        frame = new JFrame("Exemplo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        JMenuBar menuBar = new JMenuBar();
                
        JMenu menu = new JMenu("File");
        JMenuItem subMenu = new JMenuItem("An item in the submenu");
        
        subMenu.addMouseListener(new SampleMouseListener());
        menu.add(subMenu);
        menuBar.add(menu);
        
        JMenu menu2 = new JMenu("TESTE");
        
        menu2.addMenuListener(new SampleMenuListener());
        
        
        test = new JPanel();
        frame.add(test);
        menuBar.add(menu2);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
        
    }
    class SampleMenuListener implements MenuListener{
        
        @Override
        public void menuSelected(MenuEvent e) {
            test.setSize(300, 300);
            
            JDesktopPane desktop = new JDesktopPane();
            JInternalFrame internal = new JInternalFrame("SOMENTE MAIS UM TESTE", true, true, true, true);
            internal.setBounds(100, 100, 150, 150);
            //internal.setSize(300, 300);
            internal.setVisible(true);
            toolbar = new JToolBar();
            JButton click = new JButton("Click");
            toolbar.add(click);
            toolbar.setSize(100, 50);
            JMenuBar menuBar2 = new JMenuBar();
            menuBar2.add(toolbar);
            internal.setJMenuBar(menuBar2);
            
            desktop.add(internal);
            frame.setContentPane(desktop);
            
        }

        @Override
        public void menuDeselected(MenuEvent e) {
            test.setBackground(Color.blue);
        }

        @Override
        public void menuCanceled(MenuEvent e) {
            System.out.println("blablabla");
        }
    }
    
    class SampleMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            //test.setBackground(Color.pink);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            //test.setBackground(Color.green);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            toolbar = new JToolBar();
            JButton button = new JButton("button");
            toolbar.add(button);
            Container contentPane = frame.getContentPane();
            contentPane.add(toolbar, BorderLayout.NORTH);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            test.setBackground(Color.orange);        
        }

        @Override
        public void mouseExited(MouseEvent e) {
            test.setBackground(Color.black);
        }
        
    }
    
    public static void main(String[] args) {
        Menu menu = new Menu();
    }
    
}
