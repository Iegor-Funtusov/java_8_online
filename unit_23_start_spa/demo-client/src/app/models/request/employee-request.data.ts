import { ApiRequestData } from "./api-request.data";

export interface EmployeeRequestData extends ApiRequestData {
  firstName: string;
  lastName: string;
  age: number;
}
