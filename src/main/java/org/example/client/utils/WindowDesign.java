package org.example.client.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WindowDesign extends JFrame {

    private final JTextArea serverResponseArea = new JTextArea();
    private final JLabel dataHeader;

    public WindowDesign() {

        //Заголовок,лого та розмір вікна
        setTitle("Client area");//назва додатку
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//закриття вікна
        ImageIcon icon = new ImageIcon("src/main/resources/images/logo.png");
        setIconImage(icon.getImage());//іконка додатку
        setSize(315, 539);//розмір вікна
        setLocationRelativeTo(null);//вікно з'явиться по центру екрану
        setResizable(false); //не можна змінувати розмір вікна

        //Привітання
        JLabel welcomeLabel = new JLabel("Вітаємо Вас у клієнтській зоні");
        welcomeLabel.setBounds(24, 30, 250, 30);//положення та розмір привітання
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);//положення тексту по центру
        welcomeLabel.setForeground(Color.WHITE);//колір тексту білий
        welcomeLabel.setFont(new Font("Georgia Pro", Font.PLAIN, 17));//шрифт і розмір тексту

        //Поле для виводу відповіді серверу
        serverResponseArea.setOpaque(false);//колір зони відсутній (прозорий)
        serverResponseArea.setBorder(BorderFactory.createLineBorder(Color.WHITE));//колір контуру білий
        serverResponseArea.setForeground(Color.WHITE);//колір тексту білий
        serverResponseArea.setFont(new Font("Georgia Pro", Font.PLAIN, 17));//шрифт і розмір тексту

        //Смуга прокручування
        JScrollPane scrollPanel = new JScrollPane(serverResponseArea);
        scrollPanel.setBounds(25, 170, 250, 300);//положення та розмір
        scrollPanel.setOpaque(false);//колір зони відсутній (прозорий)
        scrollPanel.getViewport().setOpaque(false);//колір зони відсутній (прозорий)
        scrollPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));//колір контуру білий

        try {
            //підложка під повзунок
            BufferedImage image = ImageIO.read(new File("src/main/resources/images/background.jpg"));
            int rgb = image.getRGB(0, 0);//положення підложки
            Color color = new Color(rgb);
            scrollPanel.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = Color.decode("#99c6f0");//визначаємо колір повзунка
                    this.trackColor = color;//визначаємо колір підложки
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //Текст перед полем виводу
        dataHeader = new JLabel("Запитувані дані");
        dataHeader.setBounds(25, 120, 250, 30);//положення та розмір
        dataHeader.setHorizontalAlignment(SwingConstants.CENTER);//положення тексту по центру
        dataHeader.setForeground(Color.WHITE);//колір тексту білий
        dataHeader.setFont(new Font("Georgia Pro", Font.PLAIN, 17));//шрифт і розмір тексту
        dataHeader.setVisible(false); //невидимий до натискання на

        // Кнопка для отримання даних
        JButton getDataButton = new JButton("Отримати дані про користувачів");//напис на кнопці
        getDataButton.setBounds(25, 75, 250, 30);//положення та розмір
        getDataButton.setHorizontalAlignment(SwingConstants.CENTER);//положення тексту по центру
        getDataButton.setContentAreaFilled(false);//колір зони відсутній (прозорий)
        getDataButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));//колір контуру білий
        getDataButton.setForeground(Color.WHITE);//колір тексту білий
        getDataButton.setFont(new Font("Georgia Pro", Font.PLAIN, 15));//шрифт і розмір тексту

        //Обробка натискання кнопки
        //додаємо метод, який буде виконуватися при натисканні кнопки та аргумент, що передаватиметься
        getDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //створюємо екземпляр класу ClientRunner
                    ClientRunner clientRunner = new ClientRunner();
                    //викликаємо метод getResponse та передаємо аргумент get
                    String response = clientRunner.getResponse("get");
                    //додаємо отриману відповідь у поле виводу
                    serverResponseArea.append(response + "\n");

                    dataHeader.setVisible(true);//напис "Запитувані дані" стає видимим
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Фон вікна
        ImageIcon imageIcon = new ImageIcon("src/main/resources/images/background.jpg");
        JLabel background = new JLabel(imageIcon);//створюємо об'єкт "фон"
        background.setLayout(null);//власні налаштування

        getContentPane().add(background, BorderLayout.CENTER);//положення зображення фону по центру
        background.add(welcomeLabel);//додаємо привітання над фоном
        background.add(scrollPanel);//додаємо смугу прокручування над фоном
        background.add(getDataButton);//додаємо кнопку над фоном
        background.add(dataHeader);//додаємо напис "Запитувані дані" над фоном
    }
}