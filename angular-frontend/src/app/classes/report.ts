class Medicine {
  medicinid: string;
  drugname: string;
  unit: string;
  dosage: string;
}

class Diet {
  dietid: string;
  name: string;
  description: string;
}

export class Report {
  id: string;
  patientid: string;
  doctorid: string;
  createddate: Date;
  bloodpressure: string;
  pulserate: number;
  weight: number;
  allergies: string[];
  disabilities: string[];
  mediciness: Medicine[];
  diets: Diet[];
  patienthistory: string;
  followupdoctorid: string;
}
