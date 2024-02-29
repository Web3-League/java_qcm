public class projet1{  
  public static int lireIntPos( String invite, int min, int max){
    int x;
    while (true){
      try {
        System.out.print(invite);
        x = Terminal.lireInt();
        if (x<min)
          System.out.println("Le nombre doit etre egal a : "+min);
        else if (x>max)
          System.out.println("Le nombre doit etre inferieur ou egal a : "+max);
        else
          return x;
      } catch (TerminalException e) {
        System.out.println("Ce n'est pas un nombre.");
      }
    }
  }
  public static int proposeMenu(){
    System.out.println("-----------------------------------");
    System.out.println("1- Liste des Questions");
    System.out.println("2- Réponse à une Question ");
    System.out.println("3- Modifier un QCM");
    System.out.println("4- QUITTER"); 
    return lireIntPos("Votre choix: ",1,4);
  }
  public static int proposeChangement(){
    System.out.println("-----------------------------------");
    System.out.println("1- Questions à modifier");
    System.out.println("2- Enregistrer la bonne réponse ");
    System.out.println("3- Supprimer une question");
    System.out.println("4- Supprimer une reponse");
    System.out.println("5- QUITTER");
    return lireIntPos("Votre choix: ",1,5);
  }
  public static void afficheLaListeQuestion(String[][]qcm){
    for (int i=0; i< qcm.length; i++) {
      for (int j=0; j< qcm[i].length ; j++) {
        if (null!=qcm[i][j]){
          System.out.println(qcm[i][j]);
        }
      }
    }
  }
  public static int compteLesQuestions(int cpt,String[][]qcm){
    for (int i=0; i< qcm.length; i++) {
        if (qcm!=null){
         cpt=cpt+1;
        }
      }
    return cpt;
  } 
  public static void afficheLaQuestion(int o ,String[][]qcm){
    for (int ligne=0; ligne<=qcm[o].length-1; ligne++){
      System.out.println( qcm[o][ligne] );
    }
  }
  public static void editQuestion (int o, String[][]qcm){
    for (int ligne=0; ligne<=qcm[o].length-1; ligne++){
      System.out.println( qcm[o][ligne] );
    }
  }  
  public static int réponseCorrect (int o,int r,int score, String [][] bonneReponse){
    for (int ligne=0; ligne<=bonneReponse[o].length-1;ligne++){}
      if(bonneReponse[o][r]==null){
        score=score-1;
      }else{
        score=score+1;
      }
    return score;
  }    
    public static void afficher(int o,String[][] t){
      for (int ligne=0; ligne<=t[o].length-1; ligne++){ 
        System.out.println(t[o][ligne]);
      }
    }
    public static void main(String[] args) {
      boolean fin=false;
      int x=0;
      int q=0;
      int r=0;
      int d=0;
      int cpt=0;
      int score=0;
      int essaie=0;
      String [][] editQcm= new String [14][5];
      String [][] bonneReponse= new String [14][5];
      while(!fin){
        int choix=proposeMenu();   
        if (choix==1){
          afficheLaListeQuestion(editQcm); 
        }
        else if(choix==2){
          cpt=compteLesQuestions(cpt,editQcm);
          while(essaie<cpt){
            System.out.println("choisir une question");
            q=lireIntPos("Question : ",1,14)-1;
            afficheLaQuestion(q ,editQcm);
            r=lireIntPos("Votre réponse: ",1,4);
            score=réponseCorrect(q,r,score,bonneReponse);
            System.out.println("votre score = "+ score +" /  "+cpt);
            essaie=essaie++;
          }  
        }
        else if(choix==3){
          int admin=proposeChangement();
          if (admin==1){
            x=lireIntPos("Modifier la question",1,14)-1;
            afficher(x,editQcm);
            System.out.println("Ecrire la question et 4 réponses");
            editQcm[x][0]=Terminal.lireString();
            System.out.println("ecrire la premiere reponse");
            editQcm[x][1]=Terminal.lireString();
            System.out.println("ecrire la deuxieme reponse");
            editQcm[x][2]=Terminal.lireString();
            System.out.println("ecrire la troisieme reponse");
            editQcm[x][3]=Terminal.lireString();
            System.out.println("ecrire la quatrieme reponse");
            editQcm[x][4]=Terminal.lireString();
          }
          else if (admin==2){
            x=lireIntPos("Choisir la bonne réponse pour la question numéro ? " ,1,14)-1;
            afficher(x,editQcm);
            System.out.println("Ecrire quelle est la réponse correct proposé pour la question suivante: ");
            System.out.println(editQcm[x][0]);
            System.out.println("ecrire le numero de la question valide ");
            d=lireIntPos("l'indice correct",1,4);
            bonneReponse[x][d]="vrai";    
          }
          else if (admin==3){
            x=lireIntPos("Supprimer la question",1,14)-1;
            editQcm[x][0]= null;
            editQcm[x][1]= null;
            editQcm[x][2]= null;
            editQcm[x][3]= null;
            editQcm[x][4]= null;
          }
          else if (admin==4){
            x=lireIntPos("Supprimer la réponse",1,14)-1;
            bonneReponse[x][1]= null;
            bonneReponse[x][2]= null;
            bonneReponse[x][3]= null;
            bonneReponse[x][4]= null;
          }
          else if (admin==5){
            fin=true;
          }
          else if(choix==4){
            fin=true;
          }
        }
      }
    }
  }
  
  
  
  
