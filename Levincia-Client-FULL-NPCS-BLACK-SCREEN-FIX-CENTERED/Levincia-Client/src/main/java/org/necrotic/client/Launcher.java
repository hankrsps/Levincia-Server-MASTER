package org.necrotic.client;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

/**
 * Client Launcher.
 * @author MGT Madness, created on 24-12-2013.
 */
public class Launcher
{

        /**
         * Directory of the Download Client.
         * <p>
         * This is the location the Jar filed will be stored and executed at.
         */
        static String directory = System.getProperty("user.home") + "/AvalonBeta.jar";

        /**
         * Download link of the Download Client.
         */
        static String downloadLink = "https://www.dropbox.com/s/bxywxl1bgpbt0lk/AvalonBeta.jar?dl=1";

        /**
         * Main method used to start the launcher.
         */
        public static void main(String[] args)
        {
                createWindow();
                downloadFile();
                openDownloadClient();
        }

        /**
         * Create the JFrame window.
         */
        static void createWindow()
        {
                JFrame frame = new JFrame();
                frame = new JFrame("Downloading latest client...");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Container c = frame.getContentPane();
                Dimension d = new Dimension(260, 4);
                c.setPreferredSize(d);
                frame.pack();
                frame.setVisible(true);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                /* Progress bar. */
                final JProgressBar aJProgressBar = new JProgressBar(JProgressBar.HORIZONTAL);
                aJProgressBar.setIndeterminate(true);
                frame.add(aJProgressBar, BorderLayout.NORTH);
        }

        /**
         * Download the client.
         */
        static void downloadFile()
        {
                try
                {
                        URL url2 = new URL(downloadLink);
                        InputStream in = new BufferedInputStream(url2.openStream());
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        byte[] buf = new byte[1024];
                        int n = 0;
                        while (-1 != (n = in .read(buf)))
                        {
                                out.write(buf, 0, n);
                        }
                        out.close(); in .close();
                        byte[] response = out.toByteArray();
                        FileOutputStream fos = new FileOutputStream(directory);
                        fos.write(response);
                        fos.close();
                }
                catch (IOException e)
                {
                        JOptionPane.showMessageDialog(null, "Unable to download latest client. Please check your internet connection and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                        closeProgram();
                }
        }

        /**
         * Open the Download Client.
         */
        static void openDownloadClient()
        {
                File execute = new File(directory);

                try
                {
                        Desktop.getDesktop().open(execute);
                }
                catch (IOException e)
                {
                        e.printStackTrace();
                }
                closeProgram();
        }

        /**
         * Close the program.
         */
        static void closeProgram()
        {
                System.exit(0);
        }

}