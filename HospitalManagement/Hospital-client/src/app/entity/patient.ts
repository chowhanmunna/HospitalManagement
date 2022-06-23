import { Doctor } from "./doctor";

export class Patient{
    patientId!: number;
    name!: string;
    visitedDoctor!:Doctor
    dateOfVisit!: Date;
    prescription!: string;
}