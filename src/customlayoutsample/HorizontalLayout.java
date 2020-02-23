/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customlayoutsample;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.util.HashMap;

/**
 *
 * @author mahdi
 */
public class HorizontalLayout implements LayoutManager2 {

    private int horizontalSpacing = 0;

    private HashMap<Component, Integer> componentSpacing = new HashMap<>();
    
    public HorizontalLayout() {
    }

    public HorizontalLayout(int horizontalSpacing) 
    {
        this.horizontalSpacing = horizontalSpacing;
    }
    
    
    
    @Override
    public float getLayoutAlignmentX(Container target) 
    {
        return 0.0f;  //align left
    }

    @Override
    public float getLayoutAlignmentY(Container target) 
    {
        return 0.0f;  //align top
    }
    
    private Dimension pref = new Dimension();
    
    private void calculateSize(Container parent)
    {
        synchronized(parent.getTreeLock())
        {
            int width = 0;
            int height = 0;
            Component[] children = parent.getComponents();
            Insets in = parent.getInsets();
            
            for(Component c : children)
            {
                Dimension childPref = c.getPreferredSize();
                //parent.getin
                
                //add to the height
                width += childPref.width;
                if(childPref.height > height)
                {
                    height = childPref.height;
                }
            }
            
            height += in.top + in.bottom;
            width += in.left + in.right;            
            System.out.println("Preferred Size: " + width + " x " + height);
            pref.setSize(width, height);
        }
    }
    
    @Override
    public Dimension preferredLayoutSize(Container parent) 
    {
        System.out.println("preferredLayoutSize");        
        return pref;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) 
    {
        System.out.println("minimumLayoutSize");
        return pref;
    }
    
    @Override
    public Dimension maximumLayoutSize(Container target) 
    {
        System.out.println("maximumLayoutSize");
        return pref;
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) 
    {
        //Not used
        System.out.println("addLayoutComponent");
        if(constraints != null)
        {
            if(constraints instanceof Integer)
            {
                System.out.println("Constraint: " + (Integer) constraints);
                componentSpacing.put(comp, (Integer) constraints);
            }
        }
    }

    @Override
    public void addLayoutComponent(String name, Component comp) 
    {
        //Not used
    }

    @Override
    public void removeLayoutComponent(Component comp) 
    {
        //Not used
    }

    @Override
    public void invalidateLayout(Container target) 
    {
        System.out.println("invalidateLayout");
        calculateSize(target);
    }
   
    @Override
    public void layoutContainer(Container parent) 
    {
        System.out.println("layoutContainer");
        synchronized(parent.getTreeLock())
        {
            int x = 0;
            int y = 0;
            Component[] children = parent.getComponents();
            Insets in = parent.getInsets();
            
            y += in.top;
            x += in.left;
            
            int index = 0;
            for(Component c : children)
            {
                int spacing = horizontalSpacing;
                if(componentSpacing.containsKey(c))
                {
                    spacing = componentSpacing.get(c);
                    System.out.println("Component Spacing: " + spacing);
                }
                x += spacing;
                
                Dimension prefDim = c.getPreferredSize();
                        
                System.out.println(String.format("Child [%d] (x,y):(%d, %d) (w x h): (%d x %d)", index++, x, y, prefDim.width, prefDim.height));
                c.setBounds(x, y, prefDim.width, prefDim.height);
                x += prefDim.width + spacing;
            }
            
            y += in.bottom;
            x += in.right;
        }
        System.out.println("===== LAYOUT COMPLETED =====");
    }

    /**
     * @return the verticalSpacing
     */
    public int getVerticalSpacing() {
        return horizontalSpacing;
    }

    /**
     * @param verticalSpacing the verticalSpacing to set
     */
    public void setVerticalSpacing(int verticalSpacing) {
        this.horizontalSpacing = verticalSpacing;
    }

}
