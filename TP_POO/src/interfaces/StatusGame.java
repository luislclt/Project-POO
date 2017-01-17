package interfaces;

/*
* Grupo: 2
* ------------------------------------
* Nome: Luís Carlos Teixeira
* Número: 8140072
*
* Nome: Tânia Assis
* Número: 8150455
*/
public enum StatusGame implements Status{
    
    FINISHED, TIMED, IN_PLAY, CANCELED, POSTPONED, INVALIDO;
    
    /**
     * Método que retorna uma representação textual do estado de um jogo
     * 
     * @param status da representação textual
     * * FINISHED, TIMED, IN_PLAY
     * @return representação textual do status
     */
    public static String getStatusGame(StatusGame status){
        switch(status){
            case FINISHED:
                return "Game FINISHED";
            case TIMED: 
                return "Game TIMED";
            case IN_PLAY:
                return "Game IN PLAY";
            case CANCELED:
                return "Game CANCELED";
            case POSTPONED:
                return "Game POSTPONED";
            case INVALIDO:
                return "Game INVALIDO";
                
            default:
                return "Game Inválido";
        }
        
    }
    
    
}
