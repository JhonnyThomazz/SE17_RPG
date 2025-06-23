package special_project.rpg;

import java.util.Random;
import java.util.Scanner;

public class RpgMainWork {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int playerHealth = 100;
		int enemyHealth = 250;
		//INTRO_TUTORIAL.
		System.out.println("[bem vindo ao RPG do java!]");
		System.out.print("[quer o tutorial básico antes de começar? (y/n)]: ");
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		String tutorial = scanner.next();
		if (tutorial.equalsIgnoreCase("y")) {
			System.out.println("  ");
			System.out.println("[conhecimentos básicos:]\n");
			System.out.println("[Ataque básico - causa pouco dano, não carrega o ULTIMATE]\n");
			System.out.println("[Ataque pesado - causa dano moderado, carrega o ULTIMATE em cada uso]\n");
			System.out.println("[Defesa - bloqueia parcialmente ataques básicos e pesados de inimigos. Não bloqueia ULTIMATE]\n");
			System.out.println("[Aparada - Nega completamente o dano de ataques básicos e pesados de inimigos. Utilizada uma vez, recarrega por 4 turnos. Não bloqueia ULTIMATE]\n");
			System.out.println(
					"§=========================================================================================================================================§");
		}
		try {
			Thread.sleep(4000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" ");
		//GAME_START
		System.out.println("[Ato 01]\n");
		System.out.print("Desconhecido: Ah, tu acordou... e aí, você tá legal? Foi uma queda em tanto...\n");
		System.out.println("\n[Ruídos podem ser ouvidos do lado de fora do esconderijo: Grrrr-rhaargh!]\n");
		System.out.println(
				"Desconhecido:  Parece que os capangas do Skeletor acharam a gente... Pegue sua espada, vamos ver do que é capaz.\n");

		System.out.print("[Você aceita o desafio? (y/n)]: ");
		String acceptMission = scanner.next();
		if (!acceptMission.equalsIgnoreCase("Y")) {
			System.out.println("\n[saindo do RPG...]");
			System.out.println("§=================================================================§");
			scanner.close();
			return;
		}
		try {
			Thread.sleep(2000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		int playerUlt = 0;
		int enemyUlt = 0;
		int playerParryCooldown = 0;
		int playerAttack;
		int enemyAttack;
		
		while (playerHealth >= 0 && enemyHealth >= 0) {
			//ATTACK_LIST ULT_FULL & PARRY_FULL
			if (playerUlt == 3 && playerParryCooldown == 4) {
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("\n[---|Seu turno| " + "Vida do inimigo = |" + enemyHealth + "|---]");
				System.out.println("\n[---|Sua vida máxima = |" + playerHealth + "|---]");
				System.out.println("[--|ULTIMATE CARREGADO!|---]");
				System.out.println("1- Ataque básico");
				System.out.println("2- Ataque pesado");
				System.out.println("3- Defender");
				System.out.println("4- Aparar [!]");
				System.out.println("5- ULTIMATE [!]");
				System.out.print("\nSua escolha: ");
				playerAttack = scanner.nextInt();
				if (playerAttack > 5) {
					System.out.println("[Ataque inválido! penalidade de -5 de vida máxima.]");
					playerHealth = playerHealth - 5;
					System.out.println("[Vida máxima = " + playerHealth + "]");
				}
			}
			//ATTACK_LIST ULT_FULL
			else if (playerUlt == 3 && playerParryCooldown < 4) {
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("\n[---|Seu turno| " + "Vida do inimigo = |" + enemyHealth + "|---]");
				System.out.println("\n[---|Sua vida máxima = |" + playerHealth + "|---]");
				System.out.println("1- Ataque básico");
				System.out.println("2- Ataque pesado");
				System.out.println("3- Defender");
				System.out.println("4- ULTIMATE [!]");
				System.out.print("\nSua escolha: ");
				playerAttack = scanner.nextInt();
				if (playerAttack > 4) {
					System.out.println("[Ataque inválido! penalidade de -5 de vida máxima.]");
					playerHealth = playerHealth - 5;
					System.out.println("[Vida máxima = " + playerHealth + "]");
				}
			}
			//ATTACK_LIST PARRY_FULL
			else if(playerUlt == 0 && playerParryCooldown == 0) {
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("\n[---|Seu turno| " + "Vida do inimigo = |" + enemyHealth + "|---]");
				System.out.println("\n[---|Sua vida máxima = |" + playerHealth + "|---]");
				System.out.println("1- Ataque básico");
				System.out.println("2- Ataque pesado");
				System.out.println("3- Defender");
				System.out.println("4- Aparar [!]");
				System.out.print("\nSua escolha: ");
				playerAttack = scanner.nextInt();
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (playerAttack > 4) {
					System.out.println("[Ataque inválido! penalidade de -5 de vida máxima.]");
					playerHealth = playerHealth - 5;
					System.out.println("[Vida máxima = " + playerHealth + "]");
				}
			}
			//ATTACK_LIST BASIC
			else {
				System.out.println("\n[---|Seu turno| " + "Vida do inimigo = |" + enemyHealth + "|---]");
				System.out.println("\n[---|Sua vida máxima = |" + playerHealth + "|---]");
				System.out.println("1- Ataque básico");
				System.out.println("2- Ataque pesado");
				System.out.println("3- Defender");
				System.out.print("\nSua escolha: ");
				playerAttack = scanner.nextInt();
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (playerAttack > 4) {
					System.out.println("[Ataque inválido! penalidade de -5 de vida máxima.]");
					playerHealth = playerHealth - 5;
					System.out.println("[Vida máxima = " + playerHealth + "]");
				}
			}
			if (enemyUlt == 6) {
				enemyAttack = random.nextInt(1, 4);
				if (enemyUlt > 6) {
					enemyUlt = enemyUlt -1;
				}
			}
			else {
				enemyAttack = random.nextInt(1, 3);
			}
			if (enemyAttack == 2) {
				enemyUlt++;
			}
			if (playerAttack == 2) {
				playerUlt++;
				playerParryCooldown++;
				if(playerUlt > 3) {
					playerUlt = playerUlt -1;
				}
				if (playerParryCooldown > 4) {
					playerParryCooldown = playerParryCooldown -1;
				}
			}
			if (playerAttack == 1 && enemyAttack == 3 || playerAttack == 2 || enemyAttack == 3) {
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("[O inimigo bloqueou o seu ataque! ele causou metade do dano.]");
				enemyHealth = enemyHealth - 8;
			}
			else if (playerAttack == 1 && enemyAttack == 1 || playerAttack == 1 && enemyAttack == 2 || playerAttack ==1 && enemyAttack == 4) {
				System.out.println("Seu ataque básico atingiu o inimigo!");
				enemyHealth = enemyHealth - 16;
			}
			
		}
	}
}
