package com.edu.schoolsoapapi.soap.endpoint;


import com.edu.schoolsoapapi.courses.CourseDetails;
import com.edu.schoolsoapapi.courses.GetCourseDetailsRequest;
import com.edu.schoolsoapapi.courses.GetCourseDetailsResponse;
import com.edu.schoolsoapapi.soap.bean.Course;
import com.edu.schoolsoapapi.soap.repository.IStudentRepository;
import com.edu.schoolsoapapi.students.*;
import com.edu.schoolsoapapi.soap.bean.Student;
import com.edu.schoolsoapapi.soap.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.Optional;

@Endpoint
public class StudentDetailsEndPoint {

    @Autowired
    private IStudentRepository studentRepository;

    @PayloadRoot(namespace = "http://schoolsoapapi.edu.com/students",localPart = "GetStudentDetailsRequest")
    @ResponsePayload
    public GetStudentDetailsResponse findById(@RequestPayload GetStudentDetailsRequest request) {
        Student student = studentRepository.findById(request.getId()).get();
        GetStudentDetailsResponse studentDetailsResponse = mapStudentDetails(student);
        return  studentDetailsResponse;
    }

    private GetStudentDetailsResponse mapStudentDetails(Student student){
        StudentDetails studentDetails = mapStudent(student);
        GetStudentDetailsResponse studentDetailsResponse = new GetStudentDetailsResponse();
        studentDetailsResponse.setStudentDetails(studentDetails);
        return studentDetailsResponse;
    }


    private StudentDetails mapStudent(Student student){
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setAge(student.getAge());
        studentDetails.setId(student.getId());
        studentDetails.setName(student.getName());
        return studentDetails;
    }
}
