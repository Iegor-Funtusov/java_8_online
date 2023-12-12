import { ApiResponseData } from "./api-response.data";

export interface EmployeeResponseData extends ApiResponseData {
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
