package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。

返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。

答案中每个树的每个结点都必须有 node.val=0。

你可以按任何顺序返回树的最终列表。

 

示例：

输入：7
输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
解释：

 

提示：

1 <= N <= 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/all-possible-full-binary-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/*
令 \text{FBT}(N)FBT(N) 作为所有含 NN 个结点的可能的满二叉树的列表。

每个满二叉树 TT 含有 3 个或更多结点，在其根结点处有 2 个子结点。这些子结点 left 和 right 本身就是满二叉树。

因此，对于 N \geq 3N≥3，我们可以设定如下的递归策略：\text{FBT}(N) =FBT(N)= [对于所有的 xx，所有的树的左子结点来自 \text{FBT}(x)FBT(x) 而右子结点来自 \text{FBT}(N-1-x)FBT(N−1−x)]。

此外，通过简单的计数参数，没有满二叉树具有正偶数个结点。

最后，我们应该缓存函数 \text{FBT}FBT 之前的结果，这样我们就不必在递归中重新计算它们。


 */
public class LeetCode839 {
    Map<Integer, List<TreeNode>> memo = new HashMap();

    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left: allPossibleFBT(x))
                        for (TreeNode right: allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }

        return memo.get(N);
    }
}
