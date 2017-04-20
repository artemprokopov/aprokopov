package ru.job4j.professions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Группа тестов класса Doctor.
 * @author Prokopov Artem
 * @since 18.04.2017
 * @version 1.0
 */
public class DoctorTest {
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Object.
     * Проверяется результат возвращаемый методом whatResultWork.
     */
    @Test
    public void workWhenObjectThenWhatResultWorkFalse() {
        Doctor doctor = new Doctor("Хирург", "высшее", 5,
                "травма", "начальник отделения");
        ResultDoctorWork result = doctor.work(new Object());
        boolean expected = false;
        assertThat(result.whatResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Object.
     * Проверяется значение поля resultWork после выполнения метода work.
     */
    @Test
    public void workWhenObjectThenResultWorkString() {
        Doctor doctor = new Doctor("Хирург", "высшее", 5,
                "травма", "начальник отделения");
        ResultDoctorWork result = doctor.work(new Object());
        String expected = "Доктор Хирург сообщает: Работа не выполнена, мне не известен данный вид работы";
        assertThat(result.getResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Patient.
     * Проверяется результат возвращаемый методом whatResultWork.
     */
    @Test
    public void workWhenPatientThenWhatResultWorkTrue() {
        Doctor doctor = new Doctor("Хирург", "высшее", 5,
                "травма", "начальник отделения");
        Patient patient = new Patient();
        ResultDoctorWork result = doctor.work(patient);
        boolean expected = true;
        assertThat(result.whatResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Patient.
     * Проверяется значение поля resultWork после выполнения метода work.
     */
    @Test
    public void workWhenPatientThenResultWorkString() {
        Doctor doctor = new Doctor("Хирург", "высшее", 5,
                "травма", "начальник отделения");
        Patient patient = new Patient();
        ResultDoctorWork result = doctor.work(patient);
        String expected = "Доктор Хирург сообщает: Работа с пациентом пациент выполнена.";
        assertThat(result.getResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Patient и ClinicalRecord.
     * Проверяется результат возвращаемый методом whatResultWork.
     */
    @Test
    public void workWhenPatientAndClinicalRecordThenWhatResultWorkTrue() {
        Doctor doctor = new Doctor("Хирург", "высшее", 5,
                "травма", "начальник отделения");
        Patient patient = new Patient();
        ClinicalRecord clinicalRecord = new ClinicalRecord();
        ResultDoctorWork result = doctor.work(patient, clinicalRecord);
        boolean expected = true;
        assertThat(result.whatResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Patient и ClinicalRecord.
     * Проверяется значение поля resultWork после выполнения метода work.
     */
    @Test
    public void workWhenPatientAndClinicalRecordThenResultWorkString() {
        Doctor doctor = new Doctor("Хирург", "высшее", 5,
                "травма", "начальник отделения");
        Patient patient = new Patient();
        ClinicalRecord clinicalRecord = new ClinicalRecord();
        ResultDoctorWork result = doctor.work(patient, clinicalRecord);
        String expected = "Доктор Хирург сообщает: Работа с пациентом пациент выполнена. История болезни заполнена.";
        assertThat(result.getResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Patient и ExaminePatient.
     * Проверяется результат возвращаемый методом whatResultWork.
     */
    @Test
    public void workWhenPatientAndExaminePatientThenWhatResultWorkTrue() {
        Doctor doctor = new Doctor("Хирург", "высшее", 5,
                "травма", "начальник отделения");
        Patient patient = new Patient();
        ExaminePatient examinePatient = new ExaminePatient();
        ResultDoctorWork result = doctor.work(patient, examinePatient);
        boolean expected = true;
        assertThat(result.whatResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Patient и ExaminePatient.
     * Проверяется значение поля resultWork после выполнения метода work.
     */
    @Test
    public void workWhenPatientAndExaminePatientThenResultWorkString() {
        Doctor doctor = new Doctor("Хирург", "высшее", 5,
                "травма", "начальник отделения");
        Patient patient = new Patient();
        ExaminePatient examinePatient = new ExaminePatient();
        ResultDoctorWork result = doctor.work(patient, examinePatient);
        String expected = "Доктор Хирург сообщает: Работа с пациентом пациент выполнена. "
                + "Осмотр на предмет жалоб пациента выполнен.";
        assertThat(result.getResultWork(), is(expected));
    }
}