import { createContext } from 'react';

export const MilestoneContext = createContext<MilestoneData>({
  labelCount: 0,
  closedMilestoneCount: 0,
  milestones: [
    {
      id: 0,
      name: '',
      description: '',
      dueDate: '',
      openIssueCount: 0,
      closedIssueCount: 0,
    },
  ],
});
