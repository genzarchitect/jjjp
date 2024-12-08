export class Ground {
  groundId?: string;
  groundName?: string;
  groundAddress?: any; // We might want to define another model for Address
  groundEquipments?: string;
  groundImage?: string;
  groundOwnerEmail?: string;
  status?: string;
  categories?: string;
  openingTime?: string;
  closingTime?: string;
  pricePerSlot?:number;
}
