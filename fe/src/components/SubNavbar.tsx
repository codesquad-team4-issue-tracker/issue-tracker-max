import { Theme, css, useTheme } from '@emotion/react';
import Taps from './common/Taps';
import Button from './common/Button';
import FilterBar from './FilterBar';
import { ReactComponent as PlusIcon } from '../assets/icon/plus.svg';

type Props = {
  isIssue: boolean;
  labelCount: number;
  milestoneCount: number;
  buttonValue: string;
  onClick: () => void;
};

export default function SubNavBar({
  isIssue,
  labelCount,
  milestoneCount,
  buttonValue,
  onClick,
}: Props) {
  const theme = useTheme();

  return (
    <div css={navBar(theme, isIssue)}>
      {isIssue && <FilterBar />}
      <div className="nav-container">
        <Taps labelCount={labelCount} milestoneCount={milestoneCount} />
        <Button
          value={buttonValue}
          onClick={onClick}
          color={theme.brand.textDefault}
          backgroundColor={theme.brand.surfaceDefault}
        >
          <PlusIcon className="plus" />
        </Button>
      </div>
    </div>
  );
}

const navBar = (theme: Theme, isIssue: boolean) => css`
  display: flex;
  justify-content: space-between;
  width: 1280px;
  margin: 0 auto 24px;
  padding: 0 40px;

  .nav-container {
    width: ${isIssue ? 'auto' : '1280px'};
    display: flex;
    justify-content: space-between;
    gap: 15px;

    .plus path {
      stroke: ${theme.brand.textDefault};
    }
  }
`;
