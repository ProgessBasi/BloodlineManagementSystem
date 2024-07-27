package model;

public class AddTeamModel {
		private String PlayerUsername;
		private String PlayerName;
		private String PlayerHS;
		private String PlayerRole;
		private String PlayerACS;
		private String Country;
		private String Team;
		private int PlayerId;
		
		public AddTeamModel(String playerUsername, String playerName, String playerHS, String playerRole,
				String playerACS, String country, String team) {
			this.PlayerUsername = playerUsername;
			this.PlayerName = playerName;	
			this.PlayerHS = playerHS;
			this.PlayerRole = playerRole;
			this.PlayerACS = playerACS;
			this.Country = country;
			this.Team = team;
		}
		
		public AddTeamModel(String playerUsername, String playerName, String playerHS, String playerRole,
				String playerACS, String country, String team, int PlayerId) {
			this.PlayerUsername = playerUsername;
			this.PlayerName = playerName;	
			this.PlayerHS = playerHS;
			this.PlayerRole = playerRole;
			this.PlayerACS = playerACS;
			this.Country = country;
			this.Team = team;
			this.PlayerId = PlayerId;
		}

		public int getPlayerId() {
			return PlayerId;
		}

		public void setPlayerId(int playerId) {
			PlayerId = playerId;
		}

		public AddTeamModel() {
			super();
		}

		public String getCountry() {
			return Country;
		}

		public void setCountry(String country) {
			Country = country;
		}

		public String getTeam() {
			return Team;
		}

		public void setTeam(String team) {
			Team = team;
		}

		public String getPlayerUsername() {
			return PlayerUsername;
		}

		public void setPlayerUsername(String playerUsername) {
			PlayerUsername = playerUsername;
		}

		public String getPlayerName() {
			return PlayerName;
		}

		public void setPlayerName(String playerName) {
			PlayerName = playerName;
		}

		public String getPlayerHS() {
			return PlayerHS;
		}

		public void setPlayerHS(String playerHS) {
			PlayerHS = playerHS;
		}

		public String getPlayerRole() {
			return PlayerRole;
		}

		public void setPlayerRole(String playerRole) {
			PlayerRole = playerRole;
		}

		public String getPlayerACS() {
			return PlayerACS;
		}

		public void setPlayerACS(String playerACS) {
			PlayerACS = playerACS;
		}
		
		
}
