export class Slot {
  slotId?: string;
  groundId?: string;
  slotDate?: string;
  slotStartTiming?: string;
  slotEndTiming?: string;
  status?: string; // This can be 'available' or 'booked'
  numberOfPlayers?: number;
}
