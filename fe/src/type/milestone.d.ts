type MilestoneResponse = {
  success: boolean;
  data: MilestoneData;
};

type MilestoneData = {
  labelCount: number;
  closedMilestoneCount: number;
  milestones: Milestone[];
};

type Milestone = {
  id: number;
  name: string;
  description: string;
  dueDate: string;
  openIssueCount: number;
  closedIssueCount: number;
};
