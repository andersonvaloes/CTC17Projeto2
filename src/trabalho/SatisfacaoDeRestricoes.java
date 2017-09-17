package trabalho;

public class SatisfacaoDeRestricoes {
	int[] casas = {1, 2, 3, 4, 5};
	String[] core = {"Vermelho", "Amarelo", "Azul", "Marfim", "Verde"};
	String[]  nacionalidade = {"Ingles", "Espanhol", "Noruegues", "Ucraniano", "Japones"};
	String[] bebida = {"Suco", "Cha", "Cafe", "Leite", "Agua"};
	String[] animal = {"Zebra", "Cachorro", "Raposa", "Caramujo", "Cavalo"};
	String[] cigarro = {"Kool", "Chesterfield", "Winston", "Lucky", "Parliament"};
	int[][] adjacentes = new int[6][5];
	
	public SatisfacaoDeRestricoes() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				adjacentes[i][j] = -1;
			}
		}
	}
	
	public boolean restricoes(int[][] adj) {
		//O inglês(2,x) mora na casa vermelha(1,x)
		for(int i = 0; i < 5; i++) {
			if((adj[2][i] == 0 && adj[1][i] != 0 && adj[1][i] != -1) ||
			   (adj[2][i] != 0 && adj[1][i] == 0 && adj[2][i] != -1 )) return false;
		}
		
		//O espanhol(2,x) é dono do cachorro(4,x)
		for(int i = 0; i < 5; i++) {
			if((adj[2][i] == 1 && adj[4][i] != 1 && adj[4][i] != -1) ||
			   (adj[2][i] != 1 && adj[4][i] == 1 && adj[2][i] != -1 )) return false;
		}
		
		//O norueguês(2,x) mora na primeira casa à esquerda(0,x)
		for(int i = 0; i < 5; i++) {
			if((adj[2][i] == 2 && adj[0][i] != 0 && adj[0][i] != -1) ||
			   (adj[2][i] != 2 && adj[0][i] == 0 && adj[2][i] != -1 )) return false;
		}
		
		//Fumam-se cigarros Kool(5,x) na casa amarela(1,x)
		for(int i = 0; i < 5; i++) {
			if((adj[5][i] == 0 && adj[1][i] != 1 && adj[1][i] != -1) ||
			   (adj[5][i] != 0 && adj[1][i] == 1 && adj[5][i] != -1 )) return false;
		}
		
		//O homem que fuma cigarros Chesterfield(5,1) mora na casa ao lado do homem
		//que mora com a raposa (4,2)
		for(int i = 0; i < 5; i++) {
			if(adj[5][i] == 1){
				for(int j = 0; j < 5; j++) {
					if(adj[4][j] == 2 && Math.abs(adj[0][i]-adj[0][j]) != 1) return false;
				}
			}
		}
		
		//O norueguês(2,2) mora ao lado da casa azul(1,2)
		for(int i = 0; i < 5; i++) {
			if(adj[2][i] == 2){
				for(int j = 0; j < 5; j++) {
					if(adj[1][j] == 2 && Math.abs(adj[0][i]-adj[0][j]) != 1) return false;
				}
			}
		}
		
		//O fumante de cigarros Winston(5,2) cria caramujos(4,3)
		for(int i = 0; i < 5; i++) {
			if((adj[5][i] == 2 && adj[4][i] != 3 && adj[4][i] != -1) ||
			   (adj[5][i] != 2 && adj[4][i] == 3 && adj[5][i] != -1 )) return false;
		}
		
		//O fumante de cigarros Lucky Strike(5,3) bebe suco de laranja(3,0)
		for(int i = 0; i < 5; i++) {
			if((adj[5][i] == 3 && adj[3][i] != 0 && adj[3][i] != -1) ||
			   (adj[5][i] != 3 && adj[3][i] == 0 && adj[5][i] != -1 )) return false;
		}
		
		//O ucraniano(2,3) bebe chá(3,1)
		for(int i = 0; i < 5; i++) {
			if((adj[2][i] == 3 && adj[3][i] != 1 && adj[3][i] != -1) ||
			   (adj[2][i] != 3 && adj[3][i] == 1 && adj[2][i] != -1 )) return false;
		}
		
		//O japonês(2,4) fuma cigarros Parliament(5,4)
		for(int i = 0; i < 5; i++) {
			if((adj[2][i] == 4 && adj[5][i] != 4 && adj[5][i] != -1) ||
			   (adj[2][i] != 4 && adj[5][i] == 4 && adj[2][i] != -1 )) return false;
		}
		
		// Fumam-se cigarros Kool(5,0) em uma casa ao lado da casa em que fica o cavalo(4,4)
		for(int i = 0; i < 5; i++) {
			if(adj[5][i] == 0){
				for(int j = 0; j < 5; j++) {
					if(adj[4][j] == 4 && Math.abs(adj[0][i]-adj[0][j]) != 1) return false;
				}
			}
		}
		
		//Bebe-se café(3,2) na casa verde(1,4)
		for(int i = 0; i < 5; i++) {
			if((adj[3][i] == 2 && adj[1][i] != 4 && adj[1][i] != -1) ||
			   (adj[3][i] != 2 && adj[1][i] == 4 && adj[3][i] != -1 )) return false;
		}
		
		//A casa verde(1,4) está imediatamente à direita (à sua direita) da casa marfim(1,3)
		for(int i = 0; i < 5; i++) {
			if(adj[1][i] == 4){
				for(int j = 0; j < 5; j++) {
					if(adj[1][j] == 3 && adj[0][i]-adj[0][j] != 1) return false;
				}
			}
		}
		
		//Bebe-se leite(3,3) na casa do meio(0,2)
		for(int i = 0; i < 5; i++) {
			if((adj[3][i] == 3 && adj[0][i] != 2 && adj[0][i] != -1) ||
			   (adj[3][i] != 3 && adj[0][i] == 2 && adj[3][i] != -1 )) return false;
		}
		
		return true;
	}
	
}
