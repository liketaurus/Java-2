/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.awt.HtmlBrowser.URLDisplayer;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Help",
        id = "org.lab.MyBlog"
)
@ActionRegistration(
        iconBase = "org/lab/myicon.png",
        displayName = "#CTL_MyBlog"
)
@ActionReference(path = "Menu/Help", position = 250, separatorBefore = 225, separatorAfter = 275)
@Messages("CTL_MyBlog=ProductivityBlog.com.ua")
public final class MyBlog implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // TODO implement action body
            URLDisplayer.getDefault().showURL(new URL("http://ProductivityBlog.com.ua"));
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
