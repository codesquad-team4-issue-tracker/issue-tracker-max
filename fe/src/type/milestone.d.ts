type MilestoneResponse = {
  success: boolean;
  data: MilestoneData;
};

type MilestoneData = {
  labelCount: number;
  oppositeCount: number;
  milestones: Milestone[];
};

type Milestone = {
  id: number;
  title: string;
  description: string;
  dueDate: string;
  openIssueCount: number;
  closedIssueCount: number;
};
