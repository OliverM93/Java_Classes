import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;

public class GameGUI {
	
	JFrame window;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 72);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font smallFont = new Font("Times New Roman", Font.PLAIN, 24);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP, monsterHP;
	String weapon, position;
	boolean silverRing = false;
		
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	Random rand = new Random();

	public static void main(String[] args) {
	
			//ermöglicht, dass Buttons nicht default weiß sind --> können mit .setBackground andere Farben annehmen
		 try {
	            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
	        } catch (Exception e) {
	            e.printStackTrace(); 
	        }

		
		GameGUI game = new GameGUI();

	}

	public GameGUI() {
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		titleNamePanel = new JPanel(new BorderLayout());
		titleNamePanel.setBounds(100,100,600,150);
		titleNamePanel.setBackground(new Color(0x000000));
		titleNameLabel = new JLabel("ADVENTURE", SwingConstants.CENTER);
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setFocusable(false); //deaktiviert den weißen Rand um den Text, wenn der Cursor im GUI ist
		startButton.setBackground(Color.BLACK);
		startButton.setForeground(Color.WHITE);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		window.add(titleNamePanel);
		window.add(startButtonPanel);
		
		window.setVisible(true);
	}

	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false); //lässt den Start-Screen verschwinden
		
		mainTextPanel = new JPanel();	//Panel für Haupttext
		mainTextPanel.setBounds(100,100,600,250);
		mainTextPanel.setBackground(Color.BLACK);
		window.add(mainTextPanel);
		
		mainTextArea = new JTextArea();	//Haupttext
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel(); //Panel für die Buttons
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.BLACK);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		window.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1"); //einzelne Buttons im Game-Menü
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(smallFont);
		choice1.setFocusable(false);
		choice1.addActionListener(choiceHandler); //verbindet den Button mit einer Aktion
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(smallFont);
		choice2.setFocusable(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(smallFont);
		choice3.setFocusable(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(smallFont);
		choice4.setFocusable(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();		//HP und Weapon-Anzeige oben (mit aktuellen Werten)
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.BLACK);
		playerPanel.setLayout(new GridLayout(1,4));
		window.add(playerPanel);
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.white);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon: ");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.white);
		playerPanel.add(weaponLabelName);
		
		playerSetup();
	}
	
	public void playerSetup() {
		playerHP = 15;
		monsterHP = 20;
		weapon = "Knife";
		weaponLabelName.setText(weapon); //Argument = Text im Label
		hpLabelNumber.setText(String.valueOf(playerHP));
		
		townGate();
	}
	
	public void townGate() {
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town. A guard is\nstanding in front of you. \n\n What do you do?");
		choiceBoxTexts("Talk to the guard", "Attack the guard", "Leave", " ");
		
	}
	
	public void talkGuard() {
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello stranger. I have never seen your \nface. I'm sorry I can't let you in the town.");
		choiceBoxTexts(">","","","");
	}
	
	public void attackGuard() {
		position = "attackGuard";
		mainTextArea.setText("Guard: Hey don't be stupid! \nThe guard fought back and hit you hard \n(You received 3 damage)");
		playerHP -= 3;
		if(playerHP < 1) {
			playerHP = 0;
		}
		hpLabelNumber.setText(String.valueOf(playerHP));
		choiceBoxTexts(">","","","");
	}
	
	public void crossRoad() {
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad. \nIf you go south, you will go back to the town.");
		choiceBoxTexts("Go north", "Go east", "Go south", "Go west");
	}
	
	public void north() {
		position = "north";
		mainTextArea.setText("You arrived at a river with fresh and clean water. \nYou drink it and feel better.");
		playerHP += 2;
		hpLabelNumber.setText(String.valueOf(playerHP));
		choiceBoxTexts("Go to Crossroads.","","","");
	}
	
	public void east() {
		position = "east";
		mainTextArea.setText("You found a Long Sword in a forest.");
		weapon = "Long Sword";
		weaponLabelName.setText(weapon);
		choiceBoxTexts("Go to Crossroads.","","","");
	}
	
	public void west() {
		position = "west";
		mainTextArea.setText("You've encountered a mean monster! What are you going to do?");
		choiceBoxTexts("Fight", "Run", "", "");
	}
	
	public void fight() {
		position = "fight";
		mainTextArea.setText("What do you do?\n\nMonster HP: " + monsterHP);
		choiceBoxTexts("Attack", "Run", "", "");
	}
	
	public void playerAttack() {
		position = "playerAttack";
		int playerDamage = 0;
		if(weapon.equals("Knife")) {
			playerDamage = rand.nextInt(5) + 1; //rand-Objekt wurde als Instanzvariable deklariert, Wert zwischen 1 und 5
		}
		if(weapon.equals("Long Sword")) {
			playerDamage = rand.nextInt(8) + 1;
		}
		monsterHP -= playerDamage;
		if(monsterHP < 1) {
			monsterHP = 0;
		}
		mainTextArea.setText("You attacked the monster and dealt " + playerDamage + " damage.\n\nMonster HP: " + monsterHP);
		choiceBoxTexts(">", "", "", "");
	}
	
	public void monsterAttack() {
		position = "monsterAttack";
		int monsterDamage = 0;
		monsterDamage = rand.nextInt (6) + 1;
		playerHP -= monsterDamage;
		if (playerHP < 1) {
			playerHP = 0;
		}
		mainTextArea.setText("\n\nThe monster fought back and gave you " + monsterDamage + " damage.");
		hpLabelNumber.setText(String.valueOf(playerHP));
		choiceBoxTexts(">", "", "", "");
	}
	
	public void dead() {
		position = "dead";
		playerHP = 0;
		hpLabelNumber.setText(String.valueOf(playerHP));
		mainTextArea.setText("YOU ARE DEAD.\nGAME OVER");
		choiceBoxTexts("Restart Game", "", "", "");
	}

	public void win() {
		position = "win";
		mainTextArea.setText("You killed the monster. \nIt dropped a shiny Silver Ring.");
		silverRing = true;
		choiceBoxTexts("Go back", "", "", "");
	}
	
	public void monsterCorpse() {
		position = "monsterCorpse";
		mainTextArea.setText("The corpse of the monster is lying peacfully on \nthe ground.");
		choiceBoxTexts("Go back", "", "", "");
	}
	
	public void ending() {
		position = "ending";
		mainTextArea.setText("Guard: You've got the Silver Ring with you!\nThat means you beat the monster. You must be a good man. Come in our town!\n\nYOU'VE COMPLETED THE GAME!");
		choiceBoxTexts("Restart Game", "", "", "");
		
	}
	
	public void choiceBoxTexts(String text1, String text2, String text3, String text4) {
		choice1.setText(text1);
		choice2.setText(text2);
		choice3.setText(text3);
		choice4.setText(text4);
		
	}
	
	public class TitleScreenHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			createGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			String yourChoice = event.getActionCommand(); //z.B. "c1" oder "c2" wird, je nach Klick, dem String zugewiesen
			
			switch(position) { //position --> verrät der Kontrollinastanz, in welchem Areal/welcher Methode sich der Spieler befindet (Gate, Guard, etc.)
				case "townGate":
					switch(yourChoice) {
						case "c1":
							if(silverRing == true) {
								ending();
							} else {
								talkGuard();
							} break;
						case "c2": attackGuard(); break;
						case "c3": crossRoad(); break;
						}
						break;
				case "talkGuard":
					switch(yourChoice) {
					case "c1": townGate(); break;
					}
					break;
				case "attackGuard":
					switch(yourChoice) {
					case "c1": 
						if(playerHP < 1) {
							dead();
						} else {
							townGate();
						} break;
					}
					break;
				case "crossRoad":
					switch(yourChoice) {
					case "c1": north(); break;
					case "c2": east(); break;
					case "c3": townGate(); break;
					case "c4": 
						if(monsterHP < 1) {
							monsterCorpse();
						} else {
							west();
						} break;
					}
					break;
				case "north":
					switch(yourChoice) {
					case "c1": crossRoad(); break;
					}
					break;
				case "east":
					switch(yourChoice) {
					case "c1": crossRoad(); break;
					}
					break;
				case "west":
					switch(yourChoice) {
					case "c1": fight(); break;
					case "c2": crossRoad(); break;
					}
					break;
				case "fight":
					switch(yourChoice) {
					case "c1": playerAttack(); break;
					case "c2": crossRoad(); break;
					}
					break;
				case "playerAttack":
					switch(yourChoice) {
					case "c1": 
						if(monsterHP < 1) {
							win();
						} else {
							monsterAttack();
						} break;
					}
					break;
				case "monsterAttack":
					switch(yourChoice) {
					case "c1":
						if(playerHP < 1) {
							dead();
						} else {
							fight();
						}
						break;
					}
					break;
				case "dead":
					switch(yourChoice) {
					case "c1": 
						window.dispose();		//schließt aktuelles Fenster
						new GameGUI(); break;	//öffnet neues Fenster
					}
					break;
				case "win":
					switch(yourChoice) {
					case "c1": crossRoad(); break;
					}
					break;
				case "monsterCorpse":
					switch(yourChoice) {
					case "c1": crossRoad(); break;
					}
					break;
				case "ending":
					switch(yourChoice) {
						case "c1":
							window.dispose();		//schließt aktuelles Fenster
							new GameGUI(); break;
					}
					break;
			}
		}
	}
}
