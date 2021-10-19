package main;

import DAO.ColaboradorDao;
import model.Colaborador;
import model.Tarefa;
import services.ColaboradorServ;
import services.TarefaServ;

import javax.xml.stream.events.StartDocument;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Which category do you want to go?");
        System.out.println("1 - COLLABORATOR");
        System.out.println("2 - ASSIGNMENT");
        System.out.println("0 - EXIT");
        int option = scanner.nextInt();

        if (option == 1) {
            System.out.println("Choose the option you want:");
            System.out.println("1 - INCLUDE COLLABORATOR");
            System.out.println("2 - UPDATE COLLABORATOR");
            System.out.println("3 - DELETE COLLABORATOR");
            System.out.println("4 - LIST ALL COLLABORATORS");
            System.out.println("5 - LIST COLLABORATOR FOR ID");
            option = scanner.nextInt();

            ColaboradorServ colaboradorServ = new ColaboradorServ();

            if (option == 1) {
                System.out.println("Inform the name of collaborator:");
                String nomeColaborador = scanner.next();

                colaboradorServ.include(new Colaborador(nomeColaborador));

                System.out.println("Registered successfully!");
            } else if (option == 2) {
                System.out.println("Inform the id of collaborator:");
                int id = scanner.nextInt();

                Colaborador colaborador = colaboradorServ.findByOne(id);
                System.out.println(colaborador);

                System.out.println("Inform the new name of collaborator with id " + id);
                scanner.nextLine();
                String nomeColaborador = scanner.next();
                
                colaborador.setNomeColaborador(nomeColaborador);
                colaboradorServ.update(colaborador);

                System.out.println("Updated collaborator!");
                System.out.println(colaborador);
            } else if (option == 3) {
                System.out.println("Inform the id of collaborator:");
                int id = scanner.nextInt();

                colaboradorServ.delete(id);
                System.out.println("Deleted successfully!");
            } else if (option == 4) {
                System.out.println("List of collaborators:");
                List<Colaborador> list = colaboradorServ.findAll();
                System.out.println(list);
            } else if (option == 5) {

            }
        } else if (option == 2) {
            System.out.println("Choose the option you want:");
            System.out.println("1 - INCLUDE ASSIGNMENT");
            System.out.println("2 - UPDATE ASSIGNMENT");
            System.out.println("3 - DELETE ASSIGNMENT");
            System.out.println("4 - LIST ALL ASSIGNMENTS");
            System.out.println("5 - LIST ASSIGNMENT FOR ID");
            option = scanner.nextInt();

            TarefaServ tarefaServ = new TarefaServ();

            if (option == 1) {

                System.out.println("Inform the id of collaborator for this assignment:");
                int id = scanner.nextInt();

                System.out.println("Inform the description of the assignment:");
                String desc = scanner.next();

                System.out.println("Inform the initial date of the assignment:");
                String  dataHoraInicio = scanner.next();

                System.out.println("Inform the final date of the assignment (case not, enter x):");
                String dataHoraFim = scanner.next();

                System.out.println("Inform the status of the assignment:");
                String status = scanner.next();

                System.out.println("Inform the priority of the assignment:");
                String priority = scanner.next();

                tarefaServ.include(new Tarefa(id, desc, dataHoraInicio, dataHoraFim, status, priority));
                System.out.println("Registered successfully!");
            } else if (option == 2) {
                System.out.println("Inform the id of assignment:");
                int id = scanner.nextInt();

                Tarefa tarefa = tarefaServ.findByOne(id);
                System.out.println(tarefa);

                System.out.println("Inform the new description of assignment with id " + id);
                String desc = scanner.next();

                System.out.println("Inform the new status of assignment with id " + id);
                String status = scanner.next();

                System.out.println("Inform the new priority of assignment with id " + id);
                String priority = scanner.next();

                tarefa.setDescrTarefa(desc);
                tarefa.setStatusTarefa(status);
                tarefa.setPrioridadeTarefa(priority);

                tarefaServ.update(tarefa);

                System.out.println("Updated task!");
                System.out.println(tarefa);
            } else if (option == 3) {
                System.out.println("Inform the id of assignment:");
                int id = scanner.nextInt();

                tarefaServ.delete(id);
                System.out.println("Deleted successfully!");
            } else if (option == 4) {
                System.out.println("List of assignments:");
                List<Tarefa> list = tarefaServ.findAll();
                System.out.println(list);
            } else if (option == 5) {
                System.out.println("Inform the id of assignment you want to search:");
                int id = scanner.nextInt();

                Tarefa tarefa = tarefaServ.findByOne(id);
                System.out.println(tarefa);
            }
        }

        scanner.close();
    }
}
