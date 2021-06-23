package Ex4;

public class Avaliacao {
		private String disciplina;
		private String aluno;
		private Double nota;
		
		public Avaliacao(String disciplina, String Aluno, Double nota) {
			this.disciplina = disciplina;
			this.aluno = aluno;
			this.nota = nota;
		}
		
		public String getDisciplina() {
			return disciplina;
		}
		
		public String getAluno() {
			return aluno;
		}
		
		public Double getNota() {
			return nota;
		}
		
		public void setDisciplina(String disciplina) {
			this.disciplina = disciplina;
		}
		
		public void setAluno(String aluno) {
			this.aluno = aluno;
		}
		
		public void setNota(Double nota) {
			this.nota = nota;
		}
}
