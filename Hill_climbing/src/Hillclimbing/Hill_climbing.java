/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hillclimbing;

/**
 *
 * @author Pranita Deshpande
 */


import java.util.Random;
class fitnessCalculation//Evaluate Function based on no.of one's to calcluate fitness
{    static int ones = 0, fitnessValue, position = 0;
     static int getFitness(int newArray[]) {
 	   for (int i = 0; i < 40; i++)//itreate through array and count for number of 1's
 	      {
 	    	  if(newArray[i] == 1)
 	    		  ones = ones +1;
 	    	  else
 	    		  ones = ones;
 	      }
 	      fitnessValue = ((12 * ones ) - 160);//calcluating fitness with given funcation
 	      fitnessValue = Math.abs(fitnessValue);
 	      ones = 0;
 	      return fitnessValue;
     }
}
public class Hill_climbing { //main class
     public static void main(String[] args) 
     {
      
    	    int sampleArray[]=new int[40]; //sample(current) array of strings
    	    int neighbourArray[]=new int[40];
    	    int final_fitnessArray[]=new int[40];
    	    int count_iteration=0;
    	    int fitness_current,fitness_newString;
    	    Random randomString = new Random();
            int Max_fitness=0;
         while(count_iteration < 100)// do the execution for 100 times
         {
             for(int i=0;i<40;i++)//randomly selected the initial chromosome
             {
             	sampleArray[i]=randomString.nextInt(2); 
                
             }
             
             while(true)
             {
            	 Max_fitness = 0;
            	 fitness_current = fitnessCalculation.getFitness(sampleArray);// compute the fitness of current string
             for(int j=0;j<40;j++)//for jth neighbour
             {
                    for(int i=0;i<40;i++)//copy all sample array(current string) into neighbour
                     {   
       	                 neighbourArray[i] = sampleArray[i];
                      }
               if(sampleArray[j]==0)//change the jth position 
             	  neighbourArray[j]=1;
               else
             	  neighbourArray[j]=0;
             fitness_newString = fitnessCalculation.getFitness(neighbourArray); //compute fitness of new neighbour
             if(Max_fitness < fitness_newString)
                {
            	   Max_fitness = fitness_newString;
                   for(int i=0;i<40;i++)//copy all that neigh into final Fitness[]
                     {
                	   final_fitnessArray[i]=neighbourArray[i];
                 
                     }
                 }
             }
             //after iternating over all neighbour strings 
             if(Max_fitness <= fitness_current)//that means we reached local maxima or global maxima
             { 
                 
                 System.out.print("For iteration  "+ count_iteration);
                 System.out.println("-" + fitness_current+",");
                 break;
             }
             else
                 for(int i=0;i<40;i++)//copy all that neigh into temp[]
                   {
                 	  sampleArray[i] = final_fitnessArray[i];
                   }
              
         }
           count_iteration++;  
         }
     
     } 
}

