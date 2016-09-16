package com.spreys.inventorytracking.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vspreys on 9/15/16.
 */

public class MockDataProvider {
    private static String mockedImage = "iVBORw0KGgoAAAANSUhEUgAAAeAAAAHgCAIAAADytinCAAAAA3NCSVQICAjb4U/gAAAewklEQVR4\n" +
            "nO3dTYxl6XnQ8ef9Oud+1cet6q7umnH39LjHM2MnjifBTowVoeCwQhDIAqEsQ4RYwAoWkVgBC8Qy\n" +
            "QWwRSxYQCQhCIJIQBYFCAo48tseTjD3ununp6e6qrq9bde895/14WJzpnsmMnXgiUF5X/r9Fq+r2\n" +
            "rVPVvfjr1VPveY/Z3t4WAEB97J/2DwAA+O4INABUikADQKUINABUikADQKUINABUikADQKUINABU\n" +
            "ikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikAD\n" +
            "QKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUI\n" +
            "NABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABU\n" +
            "ikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikAD\n" +
            "QKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUI\n" +
            "NABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABU\n" +
            "ikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikAD\n" +
            "QKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUI\n" +
            "NABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABU\n" +
            "ikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikAD\n" +
            "QKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUI\n" +
            "NABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABU\n" +
            "ikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikAD\n" +
            "QKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUINABUikADQKUI\n" +
            "NABUikADQKUINABUikADQKUINABUikADQKX8n/YPAAD/vxhJIuJURMQWKyLZioj09r21qaoOfxvU\n" +
            "iEib5Ol7jsby9BU1IiJLn0Vk3hkRcUVE5NyJMWZUjIisrYrI3oWIyHeuWbH2uccaY8yq3vtHm1ZV\n" +
            "U6OiurvIOecmhJTSyqmI+C7bJ5ZBVDWVrKoEGsCfUar6wY+NMR98XVWevvLHXscYY4x5/4LOSdf1\n" +
            "vTZN0ziXUooxioh4I8YMl00plVKMt8aYyaQtpZRSVFXEWGsb74QVNIBLrDfGGJOGT5yISBIVEXVF\n" +
            "RIxaVZUsImKMGCMPNoo8CfT1cxGRo4kTkaHTz547EXkwUWOMVRERn1RU2iTGSLIiYu7siIhsriQl\n" +
            "N1E1ffn2dtZQWrUhhO0HF8YYO2qM8V9cNK20P3UxCRJUrIp2IiLSimTJS4lRIoEGcGn9sUvgJ8tZ\n" +
            "+f7Wyu8Z1rnf49upiMQYvffOaYxRs1rvndqU0mg0Wq1WOcb5fP7JzRvXr1//ieWmMca2QVW7JwOT\n" +
            "lNKiX/d9b7a3tz/GzwUAPzjWoYiIySoioYg8mTWbYSqtIiLlA6V9+oqqdl6erpSH/RRFRESapCLi\n" +
            "xIhI54uqTnsxxtzfEjHm2pmKyEkoqlqscc7tdKaUMlurqv7tdG232X3l2U/O5/OQdL1el9aHEFY5\n" +
            "5pyzFhEJ1jjnxkmYQQO45FTVfO8174f8oTny9/GeD7/5yafe+77vhwV613Uxxr3Z7s2bN/+C/+EY\n" +
            "Y5tc3/dOnDEm55xSksY755z1IuJkuIiKCCtoAJfWR2trzfuvDGvn3r33p6qWRkR10omqJmNFZP/C\n" +
            "iIgvIiKPJ1ZERlFEZNGKqqopIjLORlWHqw0r9OKtiDRRU0rJm/l8/s8f3b5165a1VlU/cW5E5P6V\n" +
            "UEr5r8+XUsrrW9la2wcjItvnxRjz8rF1zrGCBvBnzgf3bDx95bt+/Ed/1fd6T4yxaZqUYs55/8aN\n" +
            "V1555TPfutr3fYyxbdu2dV3XnZ+fHxwcfOX44OTk5HftSSllabKq7ud2Pp+r29ve3mYFDeDS2owm\n" +
            "53wW1Hu/aCTnrK6ItU2SUsokSs552MXcOmutnRbXdd39URKRrdKEEJaSRSQZVVWfrYic+iTWPpPa\n" +
            "nHNuTd/3ZxMjzl09TiIioyAizSp1Xeen42vXrv3r+IXZbLaSHGO8v+PG4/G/u3L2+uuv//fTt1JK\n" +
            "417X6/XYBVVtshUZdoPIwUyEGTSAS6zve+99CH7YpmytzVIk575LxlrnmhDCWG2MMafYdV2OxVs/\n" +
            "mUyMMW5Zuq5b5l5EmulYVWOMo9FovDFer9f9sh+Px2dxKSLi3HCPSSkl51xKacTM5/Nljp///Ofb\n" +
            "r7Sr1arZmhljVNNrr732W/Lm6enpelNFJGdp21ZS+eCP/d5uEGNYQQO4tEJSY8yZL6WUGKz3fqMv\n" +
            "OedPXQRVfSl7J+4FGTfSXJHWibNSihQj0kn3uqyjxP8yT9baN3TRNM3Vc1VVFauqB1PJOfsizrl5\n" +
            "dKp67ooxJjkppeyuTAjhV+RL+/v754045x7Yru/7fxZ+/+7du98+Pwwh6KSJMbZJRqORiSpP7k4c\n" +
            "ZtnRiXCjCoBLrGmaGGPOebjTb7hbT0Qu0sX2ePu56Y39/f3PNVdCCJvRpJSCNTlnV2xKaSOcP3jw\n" +
            "wMubBwcHumk1BBFJKeUiTdN470op1hrnXF7nnLPx3nuvVq216/XFK6+8cu3wWkrJjduu68zE/N7X\n" +
            "f+/r4U1r7cbGhnNuZYuq2lJSSl7tR6fbhhU0gEusbyWlNE7GOXdlUXLOny3tzM7+1gt/3nt/M42s\n" +
            "tcHYlFJvtZTSGhdjPJ4Y59zFRhCR5+5crNfr33z8BwtZ/HJzICKnu6PVahVzmkwmrs/OuUXpc87P\n" +
            "xZG19tubSUT+/v35l7/05f0zDSE8e1xyzj9/9fVXX331rJUQwv6FSSk9mpkQwoOZSkqzpTXGjJOI\n" +
            "yGmjIqLWCCtoAJdYzllEhvFxSjqdTp+f3rxx40azbpxztlhVLcPtISFYa20q1tqmkVJK3/ci4pyb\n" +
            "zWaf3v703bt3R6PFarUaTtVwzpVSJGdrrYhYa51zMUbpe2nbH/30j6aUnGtKKW3b3rlz59V3X3XO\n" +
            "jUYhpRRjEhFViTFKsRKCSP6uO7UJNIBLS41RkdlFEpEv6e7zV57/q+1z2257ulpaa483XUrp/1zL\n" +
            "McbXrydjzLlXVf3skTPGfOmetdYebxZr7bOTzVkz+scHs7fO3vq3h49U/Df33Wq1Kt40QUYXYow9\n" +
            "D9qVfOvU7+3t3g5bIxnls7PJZPJvPpX+/e//n+VuG2MsJRpnXv9EMMa065xS2jvSEGynqqqdtSIy\n" +
            "jSIivVUh0AAusWFXsvd+Op3e3r798ssv7xy3x8fHM9OUUlar1WKxuLM6OTw8/J03zruuOzXJWrvo\n" +
            "Nvf29n44Xt/e3jbGpJSOjo62t7efnz2vqptxfXR2FGMJIfQlD7Pjp2fRTSbT69eva6+llI3ZLMb4\n" +
            "ta+95sQtFovpdCpWnHMiRfu+FNO2rc/adZ0076f4yTCaOwkBXGqlpJTSF5bNj/3Ij/3D/NJyuXzj\n" +
            "uu/7/rrbPDo6+gfzb929ezetu6Zpoi193w+HcWQrxphbfXvt2rW9z37q5s2bv/Crx6PR6CSvR6NR\n" +
            "94079/v7P3P9jqS0nzbX67VM2/V67afjnPOnHuef+xs/91deK6WUuQ1d172y+o8xxlFUETH68Z6R\n" +
            "wgoawKWlqtbaZ/ae2dvbsw9tztm51hjz1ltv/cGDP/jm7J22bafT6cXFxVrjdDpd9ytjjLVGVdfr\n" +
            "9cOHDx/79PDhw1+QF7z3JZYQws7+/uruSuxbEoJGNcbkUoZ7uEVka7olIsOnKaXT09Pscinl+zkJ\n" +
            "5KPcaDT6f/xfAgB1MOt+b777i+0P/+ho71GTjtqysvrw8OAX06u/aU+uLNLmWh5MtDNl3pux2tEq\n" +
            "jZPEYJyY45CPTK9ny/PTswc3pt95YeMvvqmzXg6f2zj0Wd56/PwivjkyxUjUYqxde8lWftY+8+nd\n" +
            "/WcuRLVELXfu3/uN/GDca/JGRMzHzDTPJARwmd24cePq1asxxr7vJ5PJw4cPX3vztYODgxDC5nRT\n" +
            "Vfu+b9u2bduu65xzIjJMk4ebA4eF8De+8Y0HDx5MJpPhaLqtra2bN2+OZSxPFsvW2uEewqtXrw5f\n" +
            "PoyST9LJ93NC3vfCiAPApfVyHP3E5Nr4SPq+v5GdX6W/a779pnnHzjeO4vKh07AbbsdGF3q/iTq2\n" +
            "29GnktahiOgoiqo8boux6WF3cHz85mu7n1hP7SxF693fLJ/4qjz+z/ahiIgWY3U4dvozebZ1XIoY\n" +
            "MbJqzLF0k2JjNuvyxx+09FGsoAFcWjs7O7PZTFWbpvHev/POO/fu3Wvbdti8bIxxzqlq13U55xDC\n" +
            "8JxAUTXWOueGpGop7Xh87969O3fuDPudRWQ8Hm/IxvCG99bIxoiI9++teodFdJHy9HGFBBoA3vdT\n" +
            "9toPPbbGiHP2LJQ3Tt89COliqwln66t25OazpddF6nonceTOXTlsy2FbRMWK2ezNVrTGWuvcjZXf\n" +
            "Oex+yX3rV1/U3Quzcy5NNlfbbasiuYzU+lhG4kIxpqg31hlb0vC7QTka6cnkTxhoRhwALq2dnR1V\n" +
            "LaXEGK1IJ93wVMBNG/q+71dRjGmaxhgjNkrOTdOklIzVUkrOUkrRImLtcrkcjUbn5+fDzHoYT+/s\n" +
            "7MhaSine+VLKcJpdKcU5Nwymcy4iknPW4ZClj49AA/iBN+TvvYmEqnnip+OuPbCnIbfe/3p4/Nvy\n" +
            "eHORnAtra0RkHI2IPApJRDbWaow7dr0J5spSRGTtRcReW4qIFG+j0Tth+Zw7N2HHOtd1q3ZjupHa\n" +
            "VSyairdOFn1rzN1pPp/m+UpCCK6UTWmOt7z0/cZCrDFFPl6mGXEA+IE3BPpDq1TzZCgcQiildF2n\n" +
            "otba4TCN73qRpzPlj44jrLVaysnJSd/3qhpC8N5/cOI8LJwXi8WwZk8pWWutWMlZVEMI3+v7/hEI\n" +
            "NIBL5WlkReTaolw/Vw2u03yULy4kXYzMqc+uiCuyCrIK0hbTZJlf6PxCt3qz1RtfxBdxYpyYPpjO\n" +
            "y8lIziY2ZOlPz5fOnBttxLtsRta7rMbaohqsc2J+xxy9edWaopryLNtdGbtl8tF474eTmz4WAg3g\n" +
            "snna6Kfbk/W9MbAOOzc+9M4P+ejIeDhLevjCpmmGR3HHGIcvf3oboTHm9PTUWvt0f8h8PM85P90r\n" +
            "/XH/IcygAVwST2s7DCtU9VvXfc551Berbl9HD8WFmILxx1MjIpNkVNUWMcYMd/r5oqraDU8zyWqM\n" +
            "ORypiGysrfZpS9x1M56ZsIopGhFv83m2alfBdSWtrVpr33Sru01fjHdNMMu8t73zxXeDF/fqRue9\n" +
            "Lx/zN4WsoAH8wPvg1PjpPHq4CVCenMgxm81aaT86CP7gIvpDs+ynHww7NKy10+m0lDIskI0xfd8P\n" +
            "i2tjzPDclr7vDw8Ph1dKKZPJZG++14RmeOfH/XcRaAA/8D7UPn3i12env/uMFqfZli8spz8us2Ik\n" +
            "aWl7bXtVI2LNtJdpL/c35f6mHI/s8cg2xYQsj8fyeCzztex0xuQSjL2VRi+5LRPzyPrzRh7GiyG7\n" +
            "K1NisOugq5E90fTN+28X0axlmEr/7PT2T8Txn2C+IQQawOXwoa0XQ6BPT0/lyZ1+o9FoKtNhNPy9\n" +
            "LvLRvxqumXP23k8mk42NjWHDRkrp+Pj4g2vn4SdIKT18+FBEhpl1zvnZZ59tpfXe/wm2QnOaHYBL\n" +
            "5ekmaBF5MNbwQ7c+sXDnI//8emzX+j8Xd/dicz71mvK5TWpl0cqZz5NOR2o3k7R9tmKcd6uRzaWs\n" +
            "TemDnYrv+/6X8ud+2u0vu5VvfJfjnbe+8yuzx2uvm9mOimxEM1ql0tic4v295u0Xt1+I4wfx4mW3\n" +
            "tdu5+6ePbq7tofQTsevWxJIWLnVBxsWIqOtiY8yqlWT1wpcYTCNGLCtoAJfXycnJ2dnZMHc+Pz+/\n" +
            "fv36rf1bIpJSGrYtpxhLKcNJHcNJdSGE9/Zp9L21dlj5rlarGzdu3Lp16/j42BizXC77vl/K8kOD\n" +
            "76feeOON4Tvu7OwMf758++UkyXs/3Nb4dNfHcLhH0zTvH/2h+nSXCCtoAJfWMq5N439enjeny7I9\n" +
            "WbjyxTzfO1n8Rn7cWmfbENRcfxxni7gZza5pT0fSlXymcW11t4RNCT6r7dK/Wr3w90afM1uTpMU4\n" +
            "145H/8R+8z8cfOuitUakdxKtLFvTBbNyEp3kVXeWus898/w7Zbkfgw3+FTO/eSjf6g+3Yj52aWRs\n" +
            "vxFUyjJ3a5sX/XJp0k4nM7E3V/ZqZyZJZ/FjPn8FAH6ApJTu3bt3fn7uvW+a5uLiYj6fv3zt5Z2d\n" +
            "nRjjYrHw3m9ubj49x85a2/d9KWU8HnvvLy4u+r7f3Ny8vXN7Op0eHx8/ff3tt9/OTx5IOPjg7ebO\n" +
            "uTt37rzxxhuj0WiYX8cYP/vZzz67/+w0TL33xpjYdaXrhonMZDJpmmY46GO9Xg+n61lrWUEDuLTa\n" +
            "rKWL/+1a986PP/uXv552pT0s683trb/U737+2OXUP3uR77m0zvHeXM62mt6WZHWnt77P7clqVtw/\n" +
            "6j75d67+uY39q6faT9uRNeZ3r8T/9MZXftW8e9xqK96IyUZEJDpRY4KKF+P6LNbcXTy2t69f2dh6\n" +
            "S5afPnVNX77wzPOfOMrPLcpnOllc9NdWdrnRlK6fdRqiqjXGu3vb5mikxzNzNCXQAC6vSQhd1x1f\n" +
            "LNq2/ZmDjc3NzWPtVPXKlSsbk42D7SYu4z3ficjZSEpKpWQxZtyrc+7Zzd0XX3zxr80+tbu7m1My\n" +
            "xoxC03Xd/3j07bfefeu1cd80jcsiIsWIPHnU7DCUGBcbYxz3+uDBgx9qdsfj8afzbLVaLZoyn8+3\n" +
            "9q9P7fTONJ+fnz9q8sbGhuvzsLfaObcMoqrirAuBp3oDuLyCGU4HbZrmxz73yv7+/i//1ijGeCz9\n" +
            "5ubmOzvu+Pj48YNHi8Vio49Zci/Ji0+h2dzcfHFzbz6fH9t0dnZ2owtt2/7G/OLw8PCfnvzvlNLC\n" +
            "FWNMW5yIhCwiEo2KyKgYERknE2M8bEVEbrabX/7yl3/ybTOfz2/fO/feX5SYc54mc3R09NbBgyjx\n" +
            "WGKUeEW0kWZL2rGMD29ubW1tcas3gEvr4uJie3t7uVwuFouvfvWrIYTVanc2m22Etuu6iwudTCbb\n" +
            "t2+XUrYvioiUIKWUZRBr7WhZLi4u0tjN5/PxaT49PT2W0699+2tpK8UYZ1tbjw8Omnb2Xe8PHHZG\n" +
            "N01Q1cVi8Wu/9mufe+aLzjkR2/e9H4UQgl3Gvb293U/sxxjPGymlXFvbpmlGUWKMfkcCK2gAl9hG\n" +
            "lpzz2ciIyDrHpmmuvfzJl1566efvzEIIP/m26ft+XZJz7mhmjTFXO8k5H/okIuPhsbFZSyn/4uXl\n" +
            "66+//o173+m6bjFvjTGfPMjW2rsTNcZMoxhj1lZFxIsRkWlvSynHE+OcO/NZVJ/T6ebm5l+//SOj\n" +
            "0ejL73hVvX4uzrllY0opvkgpJUoRkeyMMWZnbVSVGTSAS8vFlHPuvAkh2OBzzkfLxYMHD156N3dd\n" +
            "d2thm6ZxTbDWnkpcrVblZJFzzuMwGo1GzscYz45Pjo6O/uW7X3n06NFacghh1Zic89YiGWMWrRWR\n" +
            "Vo2IJCMiYlREZCS+lLLyYozpnUop7bqUUo5//80Y42fidDQaTdYlxthbdc5pyiIizjrnbPDW2nEy\n" +
            "IsIKGsClddpkzXnWifd+OHo0p1RK2Uthe3t7dGPvypUr093t2Wz24rIxxoiTnPNp7pbL5df05ODg\n" +
            "4N1HD8/Ozq4/TiLy9jUvxkxWpZQy66Rpmgsn8uSXhOdeRUSNFZHd3sUYjar3fh1MSqmIWmu3eo0x\n" +
            "Hm+77WvXXrr9wjPPPLPf+fV6/WxsRGT/whhjFr7EGP/XvIsxEmgAl9ZJSNbard4MDwa01gbvrbXN\n" +
            "4YUx5nxsjTE52KZpXlw23nu1GmM8K31K6e5GUdWkRVU/1Y9LKW/Mi8Q47k0IYbpWVV0FKyLFiKpe\n" +
            "BJEngd7pbErJinjvu8bmnIeHXbVnq7ZtD3YbTUnWnRizr5PJZPK8mYnItYWq6qlNXdf99va673sC\n" +
            "DeDSSqkPITTW5ZxPXDbG7K2MqiYrIrJyaowxKsaYrWSttb3GUsphW0Qk5PcPydtYq7X2/o4V1Vtn\n" +
            "zjl3r41931+LrYgcjlVEhmuOshMRq6Kqo2yMMaGIqkbvrLUrs4oxbqw0hDBqGmvtKscYozqrqiej\n" +
            "975jKeXKSco5s4sDwKXVNM17TyNUNd4550RKztn6UEp5+raUUtepiJjGishwNOgQWREZzpUOIYhz\n" +
            "UkqMMaWUvXrv5Q8fLv3BHR3WWlOGgzWKqhZrjDHGDgdJ577v+/VaRKTxIYQk759DPRwAMhp5VSXQ\n" +
            "AC6tmfgudg/bLMbMk3FqSnA2uGOXUkrJqHVuKzsXQmyt977v16pqSlHVlRVjzE5vjTFxw/fGvPKu\n" +
            "pFS+vp1FZJJd04RJLCJSJmKMmUURkd2lqOrZ2BgjK6+q2hZrjElWkmbTpcba5e7YOTda577vt9bi\n" +
            "s117KVoaLaLiUzHGRBUCDeAy67pORNxo5JxzyxJj1KTOOd96VVUr3nsnJqWUU4oxWvP+QwvV6PB8\n" +
            "bhFRY2OMfW+dc82w820VY4wiTj7wCER9nwzXN8YMv58spqSU2qaJMa7Xa+99yO9NM2KM6t5P8ZOz\n" +
            "UlXYxQEA1eI0OwCoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACo\n" +
            "FIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEG\n" +
            "gEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoR\n" +
            "aACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACo\n" +
            "FIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEG\n" +
            "gEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoR\n" +
            "aACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACo\n" +
            "FIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEG\n" +
            "gEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoR\n" +
            "aACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACo\n" +
            "FIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEG\n" +
            "gEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoR\n" +
            "aACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACo\n" +
            "FIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEG\n" +
            "gEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoR\n" +
            "aACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACo\n" +
            "FIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEG\n" +
            "gEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoR\n" +
            "aACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACoFIEGgEoRaACo\n" +
            "1P8FL/VXfKm3TB8AAAAASUVORK5CYII=\n";

    public static List<Product> GetMockData() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Headphones", "test@test.com", 10, 59.99, stringToBitMap(mockedImage)));
        products.add(new Product("iPad mini", "test@test.com", 15, 99.99, stringToBitMap(mockedImage)));
        products.add(new Product("iPhone 7", "test@test.com", 3, 1100, stringToBitMap(mockedImage)));
        return products;
    }

    private static Bitmap stringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0,
                    encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
