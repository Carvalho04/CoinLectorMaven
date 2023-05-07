package br.edu.unifacear.dao;

import java.util.InputMismatchException;
import java.util.List;



import br.edu.unifacear.classes.EntityBase;
import br.edu.unifacear.dao.Fabrica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class GenericDao <T extends EntityBase> {

	
	private Class<T> persistedClass;
	
	private static EntityManager em = Fabrica.getEntityManager();

	public void salvarOuAtualizar (T obj) throws Exception {
		try {
			em.getTransaction().begin();
			
			if(obj.getId() == 0) {
				em.persist(obj);
			} else {
				em.merge(obj);
			}
			
			em.getTransaction().commit();
		} catch(Exception e) {
			throw new Exception ("Erro ao salvar: " + e.getMessage());
		}
	}
	
//	continente = new GenericDao<Continente>().findById(Continente.class, 1);
	
	public T findById(Class<T> classe, int id) {		
		return em.find(classe, id);		
	}

	public void remove (Class <T> classe, int id) throws Exception {
		
		T t = findById(classe, id);
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception ("Erro ao deletar: " + e.getMessage());
		}
		
	}
	
	
	public List<T> list (Class <T> classe){
		Query q = em.createQuery("select from " + classe.getSimpleName().toString()+ " ");
		return q.getResultList();
	}

	
//	public List<T> lista() {
//        return em.createQuery("select t from T t").getResultList();
//    }
	
//
//	   public List<T> getList() {
//	       CriteriaBuilder builder = em.getCriteriaBuilder();
//	       CriteriaQuery<T> query = builder.createQuery(persistedClass);
//	       query.from(persistedClass);
//	       return em.createQuery(query).getResultList();
//	   }
	
//	  public List<T> consultarTodos(Class <T> classe) {
//		    return this.em.createQuery(
//		        String.format("from %s", classe.getSimpleName()))
//		        .getResultList();
//		    }
	
	public class ValidaCPF {

		private static String removeCaracteresEspeciais(String doc) {
			if (doc.contains(".")) {
				doc = doc.replace(".", "");
			}
			if (doc.contains("-")) {
				doc = doc.replace("-", "");
			}
			if (doc.contains("/")) {
				doc = doc.replace("/", "");
			}
			return doc;
		}
		
	    public static boolean isCPF(String CPF) {
	    	
	    	
	    	
	    	CPF = removeCaracteresEspeciais(CPF);
	    	
	        // considera-se erro CPF's formados por uma sequencia de numeros iguais
	        if (CPF.equals("00000000000") ||
	            CPF.equals("11111111111") ||
	            CPF.equals("22222222222") || CPF.equals("33333333333") ||
	            CPF.equals("44444444444") || CPF.equals("55555555555") ||
	            CPF.equals("66666666666") || CPF.equals("77777777777") ||
	            CPF.equals("88888888888") || CPF.equals("99999999999") ||
	            (CPF.length() != 11))
	            return(false);

	        char dig10, dig11;
	        int sm, i, r, num, peso;

	        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
	        try {
	        // Calculo do 1o. Digito Verificador
	            sm = 0;
	            peso = 10;
	            for (i=0; i<9; i++) {
	        // converte o i-esimo caractere do CPF em um numero:
	        // por exemplo, transforma o caractere '0' no inteiro 0
	        // (48 eh a posicao de '0' na tabela ASCII)
	            num = (int)(CPF.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                dig10 = '0';
	            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

	        // Calculo do 2o. Digito Verificador
	            sm = 0;
	            peso = 11;
	            for(i=0; i<10; i++) {
	            num = (int)(CPF.charAt(i) - 48);
	            sm = sm + (num * peso);
	            peso = peso - 1;
	            }

	            r = 11 - (sm % 11);
	            if ((r == 10) || (r == 11))
	                 dig11 = '0';
	            else dig11 = (char)(r + 48);

	        // Verifica se os digitos calculados conferem com os digitos informados.
	            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
	                 return(true);
	            else return(false);
	                } catch (InputMismatchException erro) {
	                return(false);
	            }
	        }

	        public static String imprimeCPF(String CPF) {
	            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
	            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
	        }
	    }
	







}
