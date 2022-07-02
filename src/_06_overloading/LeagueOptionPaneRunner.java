package _06_overloading;

public class LeagueOptionPaneRunner {
	public static void main(String[] args) {
		new LeagueOptionPane().showMessageDialog("Hello");
		new LeagueOptionPane().showMessageDialog("Hello", "New frame");
		new LeagueOptionPane().showMessageDialog("Hello", "Newer frame", "leagueDark.png");
	}
}
