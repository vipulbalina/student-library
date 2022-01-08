package com.java.springboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class StudentService{
        @Autowired
        StudentRepository repo;
        @Autowired
        DeleteStudentRepository deleteRepo;


    ArrayList<Student> Student_ID = new ArrayList<>();
    ArrayList<Student> tempStudentList = new ArrayList<>();



    public ArrayList<Student> createStudent(Student student) throws Exception {


        for(int i=0;i<Student_ID.size();i++){
            {
                if(Student_ID.get(i).getEmail().equals(student.getEmail()) && Student_ID.get(i).getName().equals(student.getName())){
                    throw new Exception("The email and name already exists in the system");
                }
            }
        }
        student.setDate(new Date());
        Student_ID.add(student);
        repo.save(student);

        return Student_ID;
    }


    public Student studentList(int input){
      /*  for(int i=0;i<Student_ID.size();i++){
            if(Student_ID.get(i).getID()==input){
                return Student_ID.get(i);
            }
        }*/

        Optional<Student> student;
        student=repo.findById(input);
        if(student.isEmpty()){
            return null;
        }else{
            return student.get();
        }

    }

    public ArrayList<Student> studentListDelete(int delete){
        for(int i=0;i<Student_ID.size();i++){
            if(Student_ID.get(i).getID()==delete){
                Student_ID.remove(i);
                return Student_ID;
            }
        }
        return null;
    }

    public long studentCount(){

        long count = repo.count();
        return count;
    }

    public ArrayList<Student> studentList(){

        Iterable<Student> student;
        student = repo.findAll();
        return (ArrayList<Student>) student;
    }

    public String studentDelete(int student_ID) throws Exception {

        Optional<Student> student;
        student=repo.findById(student_ID);

        Student studentDelete = student.get();



        DeleteStudent deletedStudent = new DeleteStudent();
        deletedStudent.setID(studentDelete.getID());
        deletedStudent.setName(studentDelete.getName());
        deletedStudent.setEmail(studentDelete.getEmail());
        deletedStudent.setDate(studentDelete.getDate());

        deleteRepo.save(deletedStudent);
        if(student.isPresent()){

            repo.deleteById(student_ID);
            return "The ID is deleted successfully";
        }else{
            return "The student ID is not found";
        }


      //  int count =0;



        //return Student_ID;
    }

    public ArrayList<Student> deleteStudentList(){
        return tempStudentList;
    }

    public String studentListCheck(@PathVariable int num){
        for(int i=0;i<Student_ID.size();i++) {
            if (Student_ID.get(i).getID() == num) {
                return "The student is a current Student";
            }
        }
        for(int j=0;j<tempStudentList.size();j++)    {
           if(tempStudentList.get(j).getID()==num){
                return " This an ex-student";
            }
        }
                return"The student is not present in the system";
    }


    public Student updateStudentList(Student student) {
        student.setDate(new Date());
        return repo.save(student);
    }
}
