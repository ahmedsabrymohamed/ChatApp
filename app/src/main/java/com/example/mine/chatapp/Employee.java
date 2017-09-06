package com.example.mine.chatapp;

/**
 * Created by mine on 28/08/17.
 */

public class Employee {
    public String nationalID;
    public String name;
    public String birthDate;
    public String sectionCode;
    public String departmentCode;
    public String positionCode;
    public String hiringDate;
    public String sex;
    public String birthDestination;
    public String sectionName;
    public String departmentName;

    public Employee(String nationalID, String name, String birthDate,
                    String sectionCode, String positionCode, String hiringDate, String sex, String birthDestination) {
        this.nationalID = nationalID;
        this.name = name;
        this.birthDate = birthDate;
        this.sectionCode = sectionCode;
        this.positionCode = positionCode;
        this.hiringDate = hiringDate;
        this.sex = sex;
        this.birthDestination = birthDestination;
    }


    public Employee() {
        this.nationalID = "";
        this.name = "";
        this.birthDate = "";
        this.sectionCode = "";
        this.positionCode = "";
        this.hiringDate = "";
        this.sex = "";
        this.birthDestination = "";
        this.departmentCode="";
        this.departmentName="";
        this.sectionName="";
    }
/**
    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDepartmentCode() {
        return DepartmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        DepartmentCode = departmentCode;
    }

    public String getSectionCode() {
        return SectionCode;
    }

    public void setSectionCode(String sectionCode) {
        SectionCode = sectionCode;
    }

    public String getPositionCode() {
        return PositionCode;
    }

    public void setPositionCode(String positionCode) {
        PositionCode = positionCode;
    }

    public String getHiringDate() {
        return HiringDate;
    }

    public void setHiringDate(String hiringDate) {
        HiringDate = hiringDate;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getDivisionCode() {
        return DivisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        DivisionCode = divisionCode;
    }

    public String getLocationCode() {
        return LocationCode;
    }

    public void setLocationCode(String locationCode) {
        LocationCode = locationCode;
    }

    public String getBirthDestination() {
        return BirthDestination;
    }

    public void setBirthDestination(String birthDestination) {
        BirthDestination = birthDestination;
    }
 */
}
