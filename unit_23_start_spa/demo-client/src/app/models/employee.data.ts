export interface EmployeeData {
  id: number;
  firstName: string;
  secondName: string;
  age: number;
  salary: string;
  departmentInfoList: DepartmentInfo[];
}

export interface DepartmentInfo {
  departmentId: number;
  name: string;
}
