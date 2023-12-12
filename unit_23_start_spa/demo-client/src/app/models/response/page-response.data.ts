export interface PageResponseData<DATA> {
  totalPages: number;
  totalElements: number;
  currentPage: number;
  pageSize: number;
  isFirst: boolean;
  isLast: boolean;
  hasNext: boolean;
  hasPrevious: boolean;
  sortBy: string;
  sortType: string;
  sizes: number[];
  items: DATA[];
}
