public class TennisGame2 implements TennisGame
{
    private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};
    private static final String PLAYER_1 = "player1";

    public int p1point = 0;
    public int p2point = 0;

    public String p1res = "";
    public String p2res = "";

    public String getScore(){

        // 1. Cas de l'égalité
        if (p1point == p2point && p1point < 3) {
            return SCORE_NAMES[p1point] + "-All";
        }
        if (p1point == p2point && p1point >= 3) {
            return "Deuce";
        }

        // 2. Cas de l'avantage ou de la victoire (au moins un joueur a 4 points)
        if (p1point >= 4 || p2point >= 4) {
            if (p1point - p2point == 1) return "Advantage player1";
            if (p2point - p1point == 1) return "Advantage player2";
            if (p1point - p2point >= 2) return "Win for player1";
            return "Win for player2";
        }

        // 3. Cas classique
        p1res = SCORE_NAMES[p1point];
        p2res = SCORE_NAMES[p2point];
        return p1res + "-" + p2res;
    }

    public void setP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            p1Score();
        }

    }

    public void setP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            p2Score();
        }

    }

    public void p1Score(){
        p1point++;
    }

    public void p2Score(){
        p2point++;
    }

    public void wonPoint(String player) {
        if (PLAYER_1.equals(player))
            p1Score();
        else
            p2Score();
    }
}