/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customlayoutsample;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicToggleButtonUI;
import javax.swing.plaf.synth.SynthToggleButtonUI;

/**
 *
 * @author mahdi
 */
public class MarkerUI extends SynthToggleButtonUI
{

    /**
     * Creates a new UI object for the given component.
     *
     * @param b component to create UI object for
     * @return the UI object
     */
    public static MarkerUI createUI(JComponent b) {
        return new MarkerUI();
    }
    
    @Override
    public Dimension getMaximumSize(JComponent c) {
        return super.getMaximumSize(c);
    }

    @Override
    public Dimension getMinimumSize(JComponent c) {
        return super.getMinimumSize(c);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return super.getPreferredSize(c);
    }

    @Override
    public void update(Graphics g, JComponent c) {
        super.update(g, c);
    }

    @Override
    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
    }
    
    BasicStroke s = new BasicStroke(2.0f);
    
    @Override
    public void paint(Graphics g, JComponent c) {
        System.out.println("paint");
        super.paint(g, c);
//        Graphics2D g2d = (Graphics2D) g;
//        
//        Dimension pref = c.getPreferredSize();
//        g2d.setStroke(s);
//        g2d.setColor(Color.RED);
//        g2d.drawRect(0,0, pref.width, pref.height);
        
    }

//    @Override
//    protected void paintIcon(Graphics g, AbstractButton b, Rectangle iconRect) {
//        super.paintIcon(g, b, iconRect);
//    }

    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        super.paintButtonPressed(g, b);
    }

    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        super.paintFocus(g, b, viewRect, textRect, iconRect);
    }

    @Override
    protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
        super.paintText(g, b, textRect, text);
    }

    @Override
    protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
        super.paintText(g, c, textRect, text);
    }

    @Override
    protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
        super.paintIcon(g, c, iconRect);
    }
    
    
}
